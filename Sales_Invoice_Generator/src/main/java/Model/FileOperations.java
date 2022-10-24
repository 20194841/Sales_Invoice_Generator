package model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileOperations {
    private static String invoiceHeaderFilePath;
    private static String invoiceLineFilePath;
    public static ArrayList<InvoiceHeader> readFile() {
        
        //Read data from InvoiceHeader and InvoiceLine and put this data in InvoiceHeader array list
        ArrayList<InvoiceHeader> invoices = new ArrayList<>();
        readFromHeaderFile(invoices);
        readFromLinesFile(invoices);
        return invoices;
    }
    private static void readFromHeaderFile(ArrayList<InvoiceHeader> invoices) {
        if(!(invoiceHeaderFilePath.endsWith(".csv")||invoiceHeaderFilePath.endsWith(".CSV"))) {
            JOptionPane.showMessageDialog(null,
                    "The file provided is not csv file",
                    "Wrong file format",JOptionPane.ERROR_MESSAGE);
            return;
        }
        BufferedReader fileReader;
        try { 
            fileReader = new BufferedReader(new FileReader(invoiceHeaderFilePath)) ;
            String line;
            while ((line = fileReader.readLine()) != null) {
                int invoiceNo;
                String invoiceDate;
                String name;
                String[] headerFields = line.split(",");
                    invoiceNo = Integer.parseInt(headerFields[0]);
                    try { //Validate the invoice date is DD/MM/YYYY
                    invoiceDate = headerFields[1];
                    String[] dateFields = invoiceDate.split("/");
                    int day = Integer.parseInt(dateFields[0]);
                    int month = Integer.parseInt(dateFields[1]);
                    Integer.parseInt(dateFields[2]);
                    if (month < 1 || month > 12) {
                        throw new Exception();
                    }
                    if (day < 1 || day > 31) {
                        throw new Exception();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "The application can't extract the following date\r\n" + line,
                            "Can't extract invoice date", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                    name = headerFields[2];
                    invoices.add(new InvoiceHeader(invoiceNo, invoiceDate, name));
            }
           fileReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "The file provided is not found\r\n"+invoiceHeaderFilePath,
                    "File not found",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "The application can't extract data from the following file\r\n"+invoiceHeaderFilePath,
                    "Can't extract data from file",JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void readFromLinesFile(ArrayList<InvoiceHeader> invoices) {
        if(!(invoiceLineFilePath.endsWith(".csv")||invoiceLineFilePath.endsWith(".CSV")))
        {
            //If the file is not with extension .csv, show error message then stop reading
            JOptionPane.showMessageDialog(null,
                    "The file provided is not csv file",
                    "Wrong file format",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try { 
            BufferedReader fileReader = new BufferedReader(new FileReader(invoiceLineFilePath)) ;
            String line;
            while ((line = fileReader.readLine()) != null) {
                int invoiceNo;
                String name;
                double price;
                int count;
                String[] headerFields = line.split(",");
                invoiceNo = Integer.parseInt(headerFields[0]);
                name = headerFields[1];
                price = Double.parseDouble(headerFields[2]);
                count = Integer.parseInt(headerFields[3]);
                for (InvoiceHeader invoice : invoices) {
                    if (invoice.getInvoiceNum() == invoiceNo) {
                        invoice.addInvoiceLine(new InvoiceLine(name,price,count,invoice)); 
                        break;
                    }
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "The file provided is not found\r\n"+invoiceHeaderFilePath,
                    "File not found",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "The application can't extract data from the following file\r\n"+invoiceHeaderFilePath,
                    "Can't extract data from file",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void writeFile(ArrayList<InvoiceHeader> invoices) {
        // Write invoices data to InvoiceHeader and InvoiceLine files
        ArrayList<String> headersList = new ArrayList<>(); //this array list represents the file lines
        ArrayList<String> linesList = new ArrayList<>(); //this array list represents the file lines
        if (invoices == null || invoices.size() == 0) { //If there are no invoices to be written, show error message
            int result = JOptionPane.showConfirmDialog(null,
                    "Error",
                    "Didn't find invoices to save", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    BufferedWriter headerFile = new BufferedWriter(new FileWriter(invoiceHeaderFilePath));
                    headerFile.close();
                    BufferedWriter itemsFile = new BufferedWriter(new FileWriter(invoiceLineFilePath));
                    itemsFile.close();
                } catch (Exception e) {
                }
            }
            return;
        }
        for (InvoiceHeader selectedInvoice : invoices) { 
            headersList.add(selectedInvoice.getInvoiceNum() + "," + selectedInvoice.getInvoiceDate() + "," + selectedInvoice.getCustomerName());
            ArrayList<InvoiceLine> selectedLines = selectedInvoice.getInvoiceLines();
            if (selectedLines != null && selectedLines.size() > 0) {
                for (InvoiceLine selectedLine : selectedLines) {
                    linesList.add(selectedInvoice.getInvoiceNum() + "," + selectedLine.getItemName() + "," + selectedLine.getItemPrice() + "," + selectedLine.getCount());
                }
            }
        }

        try{ 
            BufferedWriter headerFile = new BufferedWriter(new FileWriter(invoiceHeaderFilePath));
            if (headersList.size() > 0)
            {
                for (String s : headersList) {
                    headerFile.write(s+"\n");
                }
            }
            headerFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error"+invoiceHeaderFilePath,
                    "Cannot save invoices to the file",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{ 
            BufferedWriter itemsFile = new BufferedWriter(new FileWriter(invoiceLineFilePath));
            if (linesList.size() > 0)
            {
                for (String s : linesList) {
                    itemsFile.write(s+"\n");
                }
            }
            itemsFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error"+invoiceLineFilePath,
                    "Cannot save items to the file",JOptionPane.ERROR_MESSAGE);
        }

    }
    public static void setInvoiceHeaderFilePath(String filePath) {
        invoiceHeaderFilePath = filePath;
    }

    public static void setInvoiceLineFilePath(String filePath) {
        invoiceLineFilePath = filePath;
    }
}

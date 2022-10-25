
package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.FileOperations;
import model.InvoiceHeader;
import model.LoadedInvoices;
import view.GUI;

public class Controller {
    void LoadFile() {
        JOptionPane.showMessageDialog(null,
                    "Please choose the Header File firstly then choose the Line File\r\n",
                    "Important Information", JOptionPane.WARNING_MESSAGE);
            int result;  
            result = JOptionPane.YES_OPTION;
            if(result == JOptionPane.YES_OPTION){
                String path = "";
                FileOperations.setInvoiceLineFilePath("");
                FileOperations.setInvoiceHeaderFilePath("");

                JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
                fc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
                fc.addChoosableFileFilter(filter);
                fc.setDialogTitle("Choose the invoices csv file");
                if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    path = fc.getSelectedFile().getPath();
                    FileOperations.setInvoiceHeaderFilePath(path);
                }

                if (!path.equals("")) {
                    path = "";
                    JFileChooser fc1 = new JFileChooser(System.getProperty("user.dir"));
                    fc1.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter1 = new FileNameExtensionFilter("CSV files", "csv");
                    fc1.addChoosableFileFilter(filter1);
                    fc1.setDialogTitle("Choose the items csv file");
                    if (fc1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        path = fc1.getSelectedFile().getPath();
                        FileOperations.setInvoiceLineFilePath(path);
                    }
                }

                if (!path.equals("")) {
                    LoadedInvoices.setInvoices(FileOperations.readFile());
                    GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
                    GUI.resetItemsTableAndInvoiceFormToDefault();
                }
            }
    }

    void SaveFile() {
         String path = "";
            FileOperations.setInvoiceLineFilePath("");
            FileOperations.setInvoiceHeaderFilePath("");
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
            fc.addChoosableFileFilter(filter);
            fc.setDialogTitle("Choose the invoices csv file for saving");
            fc.setSelectedFile(new File("InvoiceHeader.csv"));
            if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                path = fc.getSelectedFile().getPath();
                FileOperations.setInvoiceHeaderFilePath(path);
            }
                path = "";
                JFileChooser fc1 = new JFileChooser(System.getProperty("user.dir"));
                fc1.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter1 = new FileNameExtensionFilter("CSV files", "csv");
                fc1.addChoosableFileFilter(filter1);
                fc1.setDialogTitle("Choose the items csv file");
                fc1.setSelectedFile(new File("InvoiceLine.csv"));
                if (fc1.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    path = fc1.getSelectedFile().getPath();
                    FileOperations.setInvoiceLineFilePath(path);
                }
                FileOperations.writeFile(LoadedInvoices.getInvoices());
            
    }

    void CreateNewInvoice(int x) {
        String name = JOptionPane.showInputDialog("Please enter the Name");
        String date = JOptionPane.showInputDialog("Please enter the Date");
        try { 
            String[] dateFields = date.split("/");
            int day = Integer.parseInt(dateFields[0]);
            int month = Integer.parseInt(dateFields[1]);
            Integer.parseInt(dateFields[2]);
            if (month < 1 || month > 12) {
                throw new Exception();
            }
            if (day < 1 || day > 31) {
                throw new Exception();
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null,
                    "The application can't extract the following date, please use DD-MM-YYYY format\r\n" + date,
                    "Can't extract invoice date", JOptionPane.ERROR_MESSAGE);
            return;
        }
        x++;
        int number=x;
        InvoiceHeader newInvoice = new InvoiceHeader(number,date,name);
        LoadedInvoices.updateInvoice(newInvoice);
        GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
        GUI.resetItemsTableAndInvoiceFormToDefault();
    }

    void DeleteInvoice() {
         int selectedInvoiceNumber = GUI.getSelectedInvoiceNumber();
        if(selectedInvoiceNumber == -1) { return; }
        int result = JOptionPane.showConfirmDialog(null,
                "Are you sure ?",
                "---",JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            for(int index = 0 ; index < LoadedInvoices.getInvoices().size() ; index++) {
                if (selectedInvoiceNumber == LoadedInvoices.getInvoices().get(index).getInvoiceNum())
                {
                    LoadedInvoices.deleteInvoice(selectedInvoiceNumber);
                    break;
                }
            }
            GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
            GUI.resetItemsTableAndInvoiceFormToDefault();
        }
    }

    void CreateItem() {
      int invoiceNum;
        try {
            invoiceNum = GUI.getInvoiceNumber();
        } catch(Exception exp) {
            return;
        }
        LoadedInvoices.addNewItem(invoiceNum);
        GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
        GUI.updateLineTableAndInvoiceForm(LoadedInvoices.getInvoiceByInvoiceNumber(invoiceNum));  
    }

    void DeleteItem() {
     int index , invoiceNum;
        try {
            index = GUI.getSelectedItemIndex();
            invoiceNum = GUI.getInvoiceNumber();
        } catch(Exception exp) {
            return;
        }
        if(index >= 0)
        {
            LoadedInvoices.deleteItem(invoiceNum,index);
            GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
            GUI.updateLineTableAndInvoiceForm(LoadedInvoices.getInvoiceByInvoiceNumber(invoiceNum));
        }    }
    
}

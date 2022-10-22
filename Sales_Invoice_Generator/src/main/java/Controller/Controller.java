
package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.FileOperations;
import model.LoadedInvoices;
import view.GUI;

public class Controller {

    void LoadFile() {
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

    void CreateNewInvoice() {
       System.out.println("Create new invoice");
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

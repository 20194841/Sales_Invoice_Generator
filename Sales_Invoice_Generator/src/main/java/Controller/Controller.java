
package Controller;

import Model.FileOperations;
import Model.InvoiceHeader;
import static View.GUI.updateInvoicesTable;
import java.util.ArrayList;



public class Controller {
    
    
     void saveFile() {
               System.out.print("Save button pressed");

    }

    void LoadFile() {
        FileOperations FO = new FileOperations();
              ArrayList<InvoiceHeader> list = FO.readFile();              
       for(int i = 0; i < list.size(); i++)
        {
         updateInvoicesTable(list.get(i).getInvoiceNumber(),list.get(i).getInvoiceDate(),list.get(i).getCustomerName(),list.get(i).getTotal(),list.size());

        }

    }

    void createNewInvoice() {
       System.out.print("create button pressed");

    }

    void deleteInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void createNewItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void deleteItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }     
}

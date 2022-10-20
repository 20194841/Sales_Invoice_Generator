
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ActionHandeler implements ActionListener, ListSelectionListener {
    Controller Action = new Controller();
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Save":
                Action.saveFile();
                break;
            case "Load":
                Action.LoadFile();
                break;
            case "Create New Invoice":
                Action.createNewInvoice();
                break;
            case "Delete Invoice":
                Action.deleteInvoice();
                break;
            case "Add New Item":
                break;
            case "Delete Item":
                Action.deleteItem();
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}

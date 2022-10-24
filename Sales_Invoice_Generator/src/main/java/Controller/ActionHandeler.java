
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ActionHandeler implements ActionListener, ListSelectionListener {
    
    public void actionPerformed(ActionEvent e) {
     Controller Action = new Controller();   
        switch(e.getActionCommand()){
            case "Load File":
                Action.LoadFile();
                break;
            case "Save File":
                Action.SaveFile();
                break;
            case "Create New Invoice":
                Action.CreateNewInvoice();
                break;
            case "Delete Invoice":
                Action.DeleteInvoice();
                break;
            case "Create Item":
                Action.CreateItem();
                break;
            case "Delete Item":
                Action.DeleteItem();
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    } 
}

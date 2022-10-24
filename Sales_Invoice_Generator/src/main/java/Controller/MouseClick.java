package controller;

import model.LoadedInvoices;
import view.GUI;
import javax.swing.*;
import java.awt.event.*;

public class MouseClick extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() >= 2) 
        {
            JTable target = (JTable)e.getSource();
            int invoiceNumber = Integer.parseInt((String)target.getValueAt(target.getSelectedRow(),0));
            GUI.updateLineTableAndInvoiceForm(LoadedInvoices.getInvoiceByInvoiceNumber(invoiceNumber));
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}

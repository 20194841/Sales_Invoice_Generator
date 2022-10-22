package controller;

import model.LoadedInvoices;
import view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineInformation implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JTextField target = (JTextField) e.getSource();
        String name = target.getText();
        int invoiceNum;
        try {
            invoiceNum = GUI.getInvoiceNumber();
        } catch (Exception exp) {return;}

        LoadedInvoices.setCustomerName(invoiceNum,name);
        GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
        GUI.updateLineTableAndInvoiceForm(LoadedInvoices.getInvoiceByInvoiceNumber(invoiceNum));
    }
}

package controller;

import model.LoadedInvoices;
import view.GUI;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class LineTable implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel)e.getSource();
        int row = e.getFirstRow();
        int column = e.getColumn();
        int size = tableModel.getRowCount();
        double price;
        int count;
        int invoiceNum;
        String itemName;

        if (row < 0 || row >= size || column <1 || column >=5) {
            return;
        }
            price = Double.parseDouble(tableModel.getValueAt(row, 2).toString());
            count = Integer.parseInt(tableModel.getValueAt(row, 3).toString());
            invoiceNum = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
            itemName = tableModel.getValueAt(row,1).toString();
        LoadedInvoices.updateItem(invoiceNum,row,itemName,price,count);
        GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
        GUI.updateLineTableAndInvoiceForm(LoadedInvoices.getInvoiceByInvoiceNumber(invoiceNum));


    }
}

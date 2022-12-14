package model;

import java.util.ArrayList;

public class LoadedInvoices {
    private static ArrayList<InvoiceHeader> invoices = new ArrayList<>();
    public static ArrayList<InvoiceHeader> getInvoices() {
        return invoices;
    }
    public static void setInvoices(ArrayList<InvoiceHeader> invoices) {
        LoadedInvoices.invoices = invoices;
    }
    public static void deleteInvoice(int invoiceNum) {
        for(int index = 0 ; index < invoices.size() ; index++) {
            if(invoices.get(index).getInvoiceNum() == invoiceNum){
                invoices.remove(index);
                return;
            }
        }
    }
    public static void updateInvoice(InvoiceHeader newInvoice) {
        for(int index = 0 ; index < invoices.size() ; index++) {
            if (newInvoice.getInvoiceNum() == invoices.get(index).getInvoiceNum()) {
                invoices.set(index,newInvoice);
                return;
            }
        }
        invoices.add(newInvoice);
    }
    public static InvoiceHeader getInvoiceByInvoiceNumber(int invoiceNumber) {
        for (InvoiceHeader invoice : invoices) {
            if (invoiceNumber == invoice.getInvoiceNum()) {
                return invoice;
            }
        }
        return null;
    }
    public static void addNewItem(int invoiceNumber) {
        for (InvoiceHeader invoice : invoices) {
            if (invoiceNumber == invoice.getInvoiceNum()) {
                int itemsCount = invoice.getInvoiceLines().size();
                invoice.addInvoiceLine(new InvoiceLine("Item"+(itemsCount+1),0,0,invoice));
            }
        }
    }
    public static void deleteItem(int invoiceNumber,int index) {
        for (InvoiceHeader invoice : invoices) {
            if (invoiceNumber == invoice.getInvoiceNum()) {
                invoice.deleteItem(index);
            }
        }
    }
    public static void updateItem(int invoiceNumber,int itemIndex,String name,double price, int count) {
        for (InvoiceHeader invoice : invoices) {
            if (invoiceNumber == invoice.getInvoiceNum()) {
                invoice.updateItem( itemIndex, name, price,  count);
            }
        }
    }
    public static void setCustomerName(int invoiceNumber,String name) {
        for (InvoiceHeader invoice : invoices) {
            if (invoiceNumber == invoice.getInvoiceNum()) {
                invoice.setCustomerName(name);
            }
        }
    }
    public static void setInvoiceDate(int invoiceNumber,String date) {
        for (InvoiceHeader invoice : invoices) {
            if (invoiceNumber == invoice.getInvoiceNum()) {
                invoice.setInvoiceDate(date);
            }
        }
    }
}


package Model;

import java.util.ArrayList;

public class InvoiceHeader {
    private int InvoiceNumber;
    private String InvoiceDate;
    private String CustomerName;
    private double Total;
    private final ArrayList<InvoiceLine> invoiceLines;

    public InvoiceHeader(int num,String date,String name) {
        this.InvoiceNumber = num;
        this.InvoiceDate = date;
        this.CustomerName = name;
        this.invoiceLines = new ArrayList<>();
    }
    public int getInvoiceNumber() {
        return InvoiceNumber;
    }
    public void setInvoiceNumber(int InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }
    public String getInvoiceDate() {
        return InvoiceDate;
    }
    public void setInvoiceDate(String InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    public double getTotal() {
        return Total;
    }
    public void setTotal(double Total) {
        this.Total = Total;
    }
    public ArrayList<InvoiceLine> getInvoiceLines() {
        return this.invoiceLines;
    }

    public void addInvoiceLine(InvoiceLine invoiceLine)
    {
        this.invoiceLines.add(invoiceLine);
    }

    public void deleteItem(int index) {
        this.invoiceLines.remove(index);
    }

    public void updateItem(int itemIndex,String name,double price, int count) {
        this.invoiceLines.get(itemIndex).updateItem(name,price,count);
    }
}
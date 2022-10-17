
package Model;

public class InvoiceHeader {
    private int InvoiceNumber;
    private String InvoiceDate;
    private String CustomerName;
    private double Total;

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
}
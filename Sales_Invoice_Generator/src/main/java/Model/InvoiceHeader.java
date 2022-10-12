
package Model;

public class InvoiceHeader {
    private int InvoiceNumber;
    private String Date;
    private String CustomerName;

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }
    public void setInvoiceNumber(int Number) {
        InvoiceNumber = Number;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}
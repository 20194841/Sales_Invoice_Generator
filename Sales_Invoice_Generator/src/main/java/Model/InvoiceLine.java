
package Model;

public class InvoiceLine {
    private int InvoiceNumber;
    private String ItemName;
    private double ItemPrice;
    private int Quantity;

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public Double getItemFullPrice() {
        return Quantity * ItemPrice;
    }

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(int Number) {
        InvoiceNumber = Number;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String Name) {
        ItemName = Name;
    }

    public Double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(Double Price) {
        ItemPrice = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}

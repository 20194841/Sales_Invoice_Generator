
package Model;

public class InvoiceLine {
    private int InvoiceNumber;
    private String ItemName;
    private double ItemPrice;
    private int Quantity;
    private double Total;
    private InvoiceHeader header;

    
    public InvoiceLine(String name,double price,int count,InvoiceHeader header){
        this.ItemName = name;
        this.ItemPrice = price;
        this.Quantity = count;
        this.header = header;
    }
    public int getInvoiceNumber() {
        return InvoiceNumber;
    }
    public void setInvoiceNumber(int InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }
    public String getItemName() {
        return ItemName;
    }
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    public double getItemPrice() {
        return ItemPrice;
    }
    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    public double getTotal() {
        return Total;
    }
    public void setTotal(double Total) {
        this.Total = Quantity*ItemPrice;
    }
    public void updateItem(String name,double price, int count) {
        this.Quantity = count;
        this.ItemPrice = price;
        this.ItemName = name;
    }
}

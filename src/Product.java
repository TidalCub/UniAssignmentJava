public class Product {
    Integer ID;
    String Name;
    double unitPrice;
    int qtyInStock;
    double totalPrice;

    public Product(Integer ID, String Name, double unitPrice, int qtyInStock){
        this.ID = ID;
        this.Name = "'"+Name+"'";
        this.unitPrice = unitPrice;
        this.qtyInStock = qtyInStock;
        totalPrice = unitPrice * qtyInStock;


    }
}

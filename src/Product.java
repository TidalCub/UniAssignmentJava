public class Product {
    Integer ID;
    String Name;
    double unitPrice;
    int qtyInStock;
    double totalPrice;

    public Product(Integer ID, String Name, double unitPrice, int qtyInStock){

        this.Name = "'"+Name+"'";
        this.unitPrice = unitPrice;
        this.qtyInStock = qtyInStock;
        totalPrice = unitPrice * qtyInStock;

        if(ID != null){
            this.ID = ID;
        }else{
            this.ID = IDMaker();
        }
    }
    private Integer IDMaker(){
        int LastID = DB.lastProduct();
        Integer NewID = LastID + 1;
        return NewID;
    }
}

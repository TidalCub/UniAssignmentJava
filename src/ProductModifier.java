import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class ProductModifier {
    DB db = new DB();
    public void AllProduct() {
        System.out.print("""
                -----------------------------------------------
                              ALL CURRENT STOCK
                -----------------------------------------------
                """);
        try{

            ResultSet rs = db.allproducts();

            while(rs.next()){
                System.out.print(rs.getString("ID")+ " ");
                System.out.print(rs.getString("Name")+ " ");
                System.out.print(rs.getString("unitPrice")+ " ");
                System.out.print(rs.getString("qtyInStock")+" ");
                System.out.print(rs.getString("totalPrice")+" \n");

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.print("-----------------------------------------------\n");


    }

    public void NewProduct(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        String Name = input.next();
        System.out.print("\nEnter Products Unit Price: ");
        Double unitPrice = input.nextDouble();
        System.out.print("\nEnter Products Qty: ");
        int qty = input.nextInt();
        Product newProduct = new Product(null, Name,unitPrice,qty);
        db.newProduct(newProduct);
    }

    public void updateProduct() throws SQLException {
        Scanner input = new Scanner(System.in);
        AllProduct();
        System.out.print("\nEnter Product ID: ");
        int productID = input.nextInt();
        System.out.print("\nEnter New Qty: ");
        int newQty = input.nextInt();
        ResultSet rs = db.productLookup(productID);
        Product updatProduct = new Product(productID, rs.getString("Name"), rs.getInt("unitPrice"), newQty);
        db.updateProduct(updatProduct);




    }
    public void  removeProuct(){
        Scanner input = new Scanner(System.in);
        AllProduct();
        System.out.print("\nEnter Product ID to Delete ");
        int ID = input.nextInt();

        db.removeProduct(ID);

    }
}

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
                int ID = rs.getInt("ID");
                System.out.printf("%04d ", ID);
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
        Transaction newTransaction = new Transaction("Created", newProduct.ID, "0", Integer.toString(qty));

        db.newProduct(newProduct);
        db.TransactionWriter(newTransaction);
    }

    public void updateProduct() throws SQLException {
        Scanner input = new Scanner(System.in);
        AllProduct();
        System.out.print("\nEnter Product ID: ");
        int productID = input.nextInt();
        System.out.print("\nEnter New Qty: ");
        int newQty = input.nextInt();

        ResultSet rs = db.productLookup(productID);

        int oldQty = rs.getInt("qtyInStock");
        Transaction newTransactionReport = new Transaction("Updated", productID, Integer.toString(oldQty), Integer.toString(newQty));
        Product updatProduct = new Product(productID, rs.getString("Name"), rs.getInt("unitPrice"), newQty);

        db.updateProduct(updatProduct);
        db.TransactionWriter(newTransactionReport);



    }
    public void  removeProuct(){
        Scanner input = new Scanner(System.in);
        AllProduct();
        System.out.print("\nEnter Product ID to Delete ");
        int ID = input.nextInt();

        Transaction newTransactionReport = new Transaction("Removed", ID, "", "");

        db.removeProduct(ID);
        db.TransactionWriter(newTransactionReport);
    }

    public void transactionReport(){
        System.out.print("""
                
                -----------------------------------------------------------
                                   Transaction Report
                -----------------------------------------------------------
                
                Type    Product ID    Old Qty     Current Qty     TimeStamp
                
                """);
        try {
            ResultSet Report = db.getTransaction();
            while (Report.next()) {
            System.out.printf("%s   %04d            %s            %s            %s \n", Report.getString("Type"), Report.getInt("ProductID"), Report.getString("ChangedFrom"), Report.getString("ChangedTo"), Report.getString("Timestamp"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

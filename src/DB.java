import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class DB {
    static ConnectDB DB = new ConnectDB();
    static Connection connection = DB.DBConnect();
    static Statement statement;
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet allproducts()  {
        try{
            ResultSet rs = statement.executeQuery("select * from Stock");
            return rs;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public ResultSet productLookup(int ID){
        try{
            ResultSet singleProduct = statement.executeQuery("select * from stock where ID = " + ID + " limit 1 ");
            return singleProduct;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public void newProduct(Product newProduct){
        try{
            String insert = "INSERT INTO Stock(Name, unitPrice, qtyInStock, totalPrice) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insert);
            pstmt.setString(1, newProduct.Name);
            pstmt.setDouble(2, newProduct.unitPrice);
            pstmt.setInt(3, newProduct.qtyInStock);
            pstmt.setDouble(4, newProduct.totalPrice);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }

    }
    public String updateProduct(Product updateProduct){
        try{

            statement.executeUpdate("UPDATE Stock SET qtyInStock = " + updateProduct.qtyInStock +", totalPrice = "+ updateProduct.totalPrice + " WHERE ID = " + updateProduct.ID);


            return "Ok";
        } catch (SQLException e) {
            return e.getMessage();
        }

    }

    public String removeProduct(int ID){
        try{
            String deleteStatment = "DELETE FROM Stock WHERE ID = ?";
            PreparedStatement PrepStat = connection.prepareStatement(deleteStatment);
            PrepStat.setInt(1, ID);
            PrepStat.executeUpdate();

            return "Ok";
        } catch (SQLException e) {
            return e.getMessage();
        }

    }

}

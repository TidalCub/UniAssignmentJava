import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            throw new RuntimeException(e);
        }
    }
    public static int lastProduct(){
        try{
            ResultSet lastid = statement.executeQuery("SELECT * FROM Stock ORDER BY ID DESC LIMIT 1;");
            while(lastid.next()) {
                return lastid.getInt("ID");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
    public ResultSet productLookup(int ID){
        try{
            ResultSet singleProduct = statement.executeQuery("select * from Stock where ID = " + ID + " limit 1 ");

            return singleProduct;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void newProduct(Product newProduct){
        try{
            String insert = "INSERT INTO Stock(ID, Name, unitPrice, qtyInStock, totalPrice) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insert);
            pstmt.setInt(1, newProduct.ID);
            pstmt.setString(2, newProduct.Name);
            pstmt.setDouble(3, newProduct.unitPrice);
            pstmt.setInt(4, newProduct.qtyInStock);
            pstmt.setDouble(5, newProduct.totalPrice);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    public String updateProduct(Product updateProduct){
        try{

            statement.executeUpdate("UPDATE Stock SET qtyInStock = " + updateProduct.qtyInStock +", totalPrice = "+ updateProduct.totalPrice + " WHERE ID = " + updateProduct.ID);


            return "Ok";
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }

    }

    public void TransactionWriter(Transaction Transaction){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.now();
            String TimeStamp = dateTime.format(formatter);

            String insert = "INSERT INTO TransactionTable(Type, ProductID, ChangedFrom, ChangedTo, TimeStamp) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insert);
            pstmt.setString(1, Transaction.Type);
            pstmt.setInt(2, Transaction.ProductID);
            pstmt.setString(3, Transaction.ChangedFrom);
            pstmt.setString(4,Transaction.ChangedTo);
            pstmt.setString(5, TimeStamp);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getTransaction(){
        try{
            ResultSet report = statement.executeQuery("select * from TransactionTable");
            return report;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

}

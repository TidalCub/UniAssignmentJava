import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Provides connection to the Database
public class ConnectDB {
   public static Connection DBConnect(){
       Connection connection = null;

    try{
        connection = DriverManager.getConnection("jdbc:sqlite:Site.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec

        statement.executeUpdate("create TABLE IF NOT EXISTS Stock (ID integer PRIMARY KEY, Name string, unitPrice double, qtyInStock integer, totalPrice double)");
        statement.executeUpdate("create TABLE IF NOT EXISTS TransactionTable (ID integer PRIMARY KEY autoincrement, Type string, ProductID integer ,ChangedFrom string, ChangedTo string, Timestamp string)");
        return connection;
    } catch (SQLException e) {
        //throw new RuntimeException(e);
        System.err.println(e);
    }

       return connection;
   }


}

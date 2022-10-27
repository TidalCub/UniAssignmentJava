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

        statement.executeUpdate("create table IF NOT EXISTS Stock (ID integer PRIMARY KEY autoincrement, Name string, unitPrice double, qtyInStock integer, totalPrice double)");


    } catch (SQLException e) {
        //throw new RuntimeException(e);
        System.err.println(e.getMessage());
    }
    return connection;
   }


}

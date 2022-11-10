import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction
{

    String Type;
    int ProductID;
    String ChangedFrom;
    String ChangedTo;
    LocalDateTime TimeStamp;



    public Transaction(String Type, int ProductID, String ChangedFrom, String ChangedTo){


        this.Type = Type;
        this.ProductID = ProductID;
        this.ChangedFrom = ChangedFrom;
        this.ChangedTo = ChangedTo;






    }



}

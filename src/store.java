import org.json.simple.parser.ParseException;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class store
{
    public static void main(String args[]) throws IOException, ParseException, SQLException {
        System.out.println("""
                ╦┌┐┌┬  ┬┌─┐┌┐┌┌┬┐┌─┐┬─┐┬ ┬  ╔╦╗┌─┐┌┐┌┌─┐┌─┐┌─┐┌┬┐┌─┐┌┐┌┌┬┐  ╔═╗┬ ┬┌─┐┌┬┐┌─┐┌┬┐
                ║│││└┐┌┘├┤ │││ │ │ │├┬┘└┬┘  ║║║├─┤│││├─┤│ ┬├┤ │││├┤ │││ │   ╚═╗└┬┘└─┐ │ ├┤ │││
                ╩┘└┘ └┘ └─┘┘└┘ ┴ └─┘┴└─ ┴   ╩ ╩┴ ┴┘└┘┴ ┴└─┘└─┘┴ ┴└─┘┘└┘ ┴   ╚═╝ ┴ └─┘ ┴ └─┘┴ ┴
                                                                                         v1.0""");
        loop: while(true){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------");
        System.out.println("1. ADD NEW ITEM");
        System.out.println("2. UPDATE QUANTITY OF EXISTING ITEM");
        System.out.println("3. REMOVE ITEM");
        System.out.println("4. VIEW DAILY TRANSACTION REPORT");
        System.out.println("5. DISPLAY CURRENT STOCK");
        System.out.println("---------------------------------");
        System.out.println("6. Exit");


        System.out.print("\n Enter a choice and Press ENTER to continue[1-5]:");
        int userinput = input.nextInt();

        ProductModifier pm = new ProductModifier();

         switch (userinput){
            case 1:

                pm.NewProduct();
                System.out.println("New Product Added ");
                break;
            case 2:
                pm.updateProduct();
                System.out.println("\n Item quantity updated \n\n");
                break;
            case 3:
                pm.removeProuct();
                System.out.print("\n Item Removed");
                break;
            case 4:
                System.out.print("\n Report printed");
                pm.transactionReport();
                break;
            case 5:

                pm.AllProduct();
                break;
            case 6:
                System.out.println("Exiting... ");
                System.out.println("\n\n Thanks for using this program...!");
                break loop;
             case 7:

                 break;

            default:
                System.out.println("This doesn't appear to be a valid option...!");
        }




    }

    }
}
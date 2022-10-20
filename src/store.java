import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class store
{
    public static void main(String args[]) throws IOException, ParseException {

        Scanner input = new Scanner(System.in);
        System.out.println("""
                ╦┌┐┌┬  ┬┌─┐┌┐┌┌┬┐┌─┐┬─┐┬ ┬  ╔╦╗┌─┐┌┐┌┌─┐┌─┐┌─┐┌┬┐┌─┐┌┐┌┌┬┐  ╔═╗┬ ┬┌─┐┌┬┐┌─┐┌┬┐
                ║│││└┐┌┘├┤ │││ │ │ │├┬┘└┬┘  ║║║├─┤│││├─┤│ ┬├┤ │││├┤ │││ │   ╚═╗└┬┘└─┐ │ ├┤ │││
                ╩┘└┘ └┘ └─┘┘└┘ ┴ └─┘┴└─ ┴   ╩ ╩┴ ┴┘└┘┴ ┴└─┘└─┘┴ ┴└─┘┘└┘ ┴   ╚═╝ ┴ └─┘ ┴ └─┘┴ ┴
                                                                                         v1.0""");
        System.out.println("-----------------------------------------------");
        System.out.println("1. ADD NEW ITEM");
        System.out.println("2. UPDATE QUANTITY OF EXISTING ITEM");
        System.out.println("3. REMOVE ITEM");
        System.out.println("4. VIEW DAILY TRANSACTION REPORT");
        System.out.println("5. VIEW ITEM FILE");
        System.out.println("---------------------------------");
        System.out.println("6. Exit");


        System.out.print("\n Enter a choice and Press ENTER to continue[1-5]:");
        int userinput = input.nextInt();

        switch (userinput){
            case 1:
                System.out.print("\n New Item Added");
                break;
            case 2:
                System.out.print("\n Item quantity updated");
                break;
            case 3:
                System.out.print("\n Item Removed");
                break;
            case 4:
                System.out.print("\n Report printed");
                break;
            case 5:
                JsonModifyer output = new JsonModifyer();
                System.out.println(output.JSONgetter());
                break;
            case 6:
                System.out.println("Exiting... ");
                break;
            default:
                System.out.println("This doesn't appear to be a valid option...!");
        }



        System.out.println("\n\n Thanks for using this program...!");
    }
}
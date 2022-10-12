import java.io.*;
import java.util.Scanner;

public class store
{
    public static void main(String args[])
    {

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
        System.out.println("---------------------------------");
        System.out.println("5. Exit");


        System.out.print("\n Enter a choice and Press ENTER to continue[1-5]:");
        int userinput = input.nextInt();


        while(userinput !=5)
        {
            if (userinput>5 || userinput<1) {
                System.out.println("This doesn't appear to be a valid option...!");
                break;
            }
            if (userinput == 1)	{
                System.out.print("\n New Item Added");
                break;
            }
            else if (userinput == 2) {
                System.out.print("\n Item quantity updated");
                break;
            }
            else if (userinput == 3) {
                System.out.print("\n Item Removed");
                break;
            }
            else if (userinput == 4) {
                System.out.print("\n Report printed");
                break;
            }

        }

        System.out.println("\n\n Thanks for using this program...!");
    }
}
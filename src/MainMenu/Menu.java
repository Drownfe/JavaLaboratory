package MainMenu;

import Bicycle.Borrow;
import Bicycle.Pay;
import Bicycle.Return;
import Bicycle.TicketHistory;
import Except.DAccess;
import User.RegisterUser;
import java.util.Scanner;

public class Menu {
    public static void generalMenu()  {
        System.out.println();
        System.out.println("**********************************");
        System.out.println("\t\tWelcome to Bici-U");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("Insert one of the following options:\n" +
                "1. Register user\n" +
                "2. Borrow bicycle\n" +
                "3. Return bicycle\n" +
                "4. Pay tickets\n" +
                "5. Tickets history\n" +
                "6. Exit");
        System.out.println();
        selectMenu();
    }
    public static void selectMenu() {
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();;
        do{
            switch (select){
                case 1:
                    RegisterUser.registration();
                    break;
                case 2:
                    try {
                        Borrow.fileReader();
                    } catch (DAccess e) {
                        throw new RuntimeException(e);
                    }
                    Borrow.borrowBicycle();
                    break;
                case 3:
                    Return.returnBicycle();
                    break;
                case 4:
                    Pay.payTicket();
                    break;
                case 5:
                    TicketHistory.allTickets();
                case 6:
                    System.out.println("It was a pleasure, please come back!!!");
                    System.exit(0);
            }
        }while(select != 6);
    }

}

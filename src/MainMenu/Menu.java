package MainMenu;

import Bicycle.Borrow;
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
        Borrow b = new Borrow();
        int select = sc.nextInt();;
        do{
            switch (select){
                case 1:
                    RegisterUser.registration();
                    break;
                case 2:
                    //b.borrowBicycle();
                    break;
                case 3:
                    //returnBicycle();
                    break;
                case 4:
                    //payTicket();
                    break;
                case 5:
                    //ticketHistory();
                case 6:
                    System.out.println("It was a pleasure, please come back!!!");
                    System.exit(0);
            }
        }while(select != 6);
    }

}

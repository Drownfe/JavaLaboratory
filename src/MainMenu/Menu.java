package MainMenu;

import Users.Student;

import java.util.Scanner;

public class Menu {
    public static void generalMenu() {
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
    public static void selectMenu(){
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();;
        do{
            switch (select){
                case 1:
                    registration();
                    break;
                case 2:
                    //borrowBicycle();
                    break;
                case 3:
                    //returnBicycle();
                    break;
                case 4:
                    //payTicket();
                    break;
                case 5:
                    //ticketHistory();
                case 0:
                    System.out.println("It was a pleasure, please come back!!!");
                    System.exit(0);
            }
        }while(select > 0);
    }
    public static void registration(){
        System.out.println();
        System.out.println("**********************************");
        System.out.println("\t\tUSER REGISTRATION");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("Are you Student or Professor?");
        System.out.println("Please choose");
        System.out.println();
        System.out.println("1. Student (S)\n" +
                           "2. Professor (P)\n" +
                           "3. Menu");
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
            switch (select) {
                case 1:
                    student.studentRegistration();
                    break;
                case 2:
                    professorRegistration();
                    break;
                case 3:
                    generalMenu();
                    break;
                default:
                    System.out.println("Please select a correct option");
                    break;
            }
    }
    public static void professorRegistration(){

    }
}

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
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
            switch (select) {
                case 1:
                    studentRegistration();
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
    public static void studentRegistration(){
        System.out.println("Please type your age");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        String info = "";
        info = sc.nextLine();
        if (age >=18)
        {
            System.out.println("Please type your DNI");
            String DNI = sc.nextLine();
            System.out.println("Please type your name");
            String name = sc.nextLine();
            System.out.println("Please type your surname");
            String surname = sc.nextLine();
            System.out.println();
            String id = "";
            id = "S-" + DNI;
            Student student = new Student(DNI, name, surname, age, id);
            student.setAge(age);
            student.setDNI(DNI);
            student.setName(name);
            student.setSurname(surname);
            student.setId(id);
            System.out.println("**************************");
            System.out.println("Register completed!!!");
            System.out.println("ID: "+student.getId() +"\nName: " + student.getName()
                    + " " + student.getSurname() + "\nAge: " + student.getAge());
            System.out.println("**************************");
            generalMenu();

        }else {
            System.out.println("Sorry, you must be at least 18 years");
        }
    }
    public static void professorRegistration(){

    }
}

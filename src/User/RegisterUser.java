package User;

import MainMenu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import MainMenu.Menu;

public class RegisterUser {
    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<User>();

    static List<String> ids = new ArrayList<>();

    static List<String> names = new ArrayList<>();

    static List<Boolean> debtList = new ArrayList<>();

    public static void registration() {
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
                Menu.generalMenu();
                break;
            default:
                System.out.println("Please select a correct option");
                break;
        }
    }
    public static void studentRegistration() {
        System.out.println("**********************************");
        System.out.println("\t\tSTUDENT REGISTRATION");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("Please type your age");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        String info = "";
        info = sc.nextLine();
        if (age >= 18) {
            System.out.println("Please type your DNI");
            String DNI = sc.nextLine();
            System.out.println("Please type your name");
            String name = sc.nextLine();
            System.out.println("Please type your surname");
            String surname = sc.nextLine();
            boolean debt = false;
            System.out.println();
            String id = "S-" + DNI;
            User student = new Student(DNI, name, surname, age, debt);
            student.setAge(age);
            student.setDNI(DNI);
            student.setName(name);
            student.setSurname(surname);
            System.out.println("**************************");
            System.out.println("Register completed!!!");
            System.out.println("ID: " + id + "\nName: " + student.getName()
                    + " " + student.getSurname() + "\nAge: " + student.getAge());
            System.out.println("**************************");
            Menu.generalMenu();
            users.add(student);
            ids.add(id);
            names.add(student.getName() + " " + student.getSurname());
            debtList.add(debt);
        } else {
            System.out.println("Sorry, you must be at least 18 years");
        }
    }

    public static void professorRegistration() {
        System.out.println("**********************************");
        System.out.println("\t\tPROFESSOR REGISTRATION");
        System.out.println("**********************************");
        System.out.println();
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
            boolean debt = false;
            String id = "P-" + DNI;
            User professor = new Professor(DNI, name, surname, age,debt);
            professor.setAge(age);
            professor.setDNI(DNI);
            professor.setName(name);
            professor.setSurname(surname);
            System.out.println("**************************");
            System.out.println("Register completed!!!");
            System.out.println("ID: "+id +"\nName: " + professor.getName()
                    + " " + professor.getSurname() + "\nAge: " + professor.getAge());
            System.out.println("**************************");
            Menu.generalMenu();
        }else {
            System.out.println("Sorry, you must be at least 18 years");
        }
    }
}

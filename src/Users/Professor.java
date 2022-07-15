package Users;

import MainMenu.Menu;

import java.util.Scanner;

public class Professor extends User{
    public Professor(String DNI, String name, String surname, int age,String id) {
        super(DNI, name, surname, age, id);
    }
    public Professor() {
    }
    public static void professorRegistration(){
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
            String id = "";
            id = "P-" + DNI;
            Professor professor = new Professor(DNI, name, surname, age, id);
            professor.setAge(age);
            professor.setDNI(DNI);
            professor.setName(name);
            professor.setSurname(surname);
            professor.setId(id);
            System.out.println("**************************");
            System.out.println("Register completed!!!");
            System.out.println("ID: "+professor.getId() +"\nName: " + professor.getName()
                    + " " + professor.getSurname() + "\nAge: " + professor.getAge());
            System.out.println("**************************");
            Menu menu = new Menu();
            menu.generalMenu();
        }else {
            System.out.println("Sorry, you must be at least 18 years");
        }
    }
}

package Users;

import MainMenu.Menu;

import java.util.Scanner;

public class Student extends User{
    public Student(String DNI, String name, String surname, int age,String id) {
        super(DNI, name, surname, age,id);
    }
    public Student() {
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
            Menu menu = new Menu();
            menu.generalMenu();
        }else {
            System.out.println("Sorry, you must be at least 18 years");
        }
    }

}

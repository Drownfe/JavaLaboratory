package Bicycle;

import Data.Accessing;
import Except.DAccess;
import Except.DReading;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import static User.RegisterUser.ids;
import static User.RegisterUser.names;
import static User.RegisterUser.debtList;
public class Borrow {
    static List<Bicycle> bicycles = new ArrayList<>();
    static List<String> bicyclesData = new ArrayList<>();
    static List<String> codes = new ArrayList<>();
    static List<String> colors = new ArrayList<>();
    static List<String> types = new ArrayList<>();
    static List<Boolean> available = new ArrayList<>();
    static Accessing impl = new Accessing();
    static Scanner sc = new Scanner(System.in);
    static String id;
    static int number;
    public static void borrowBicycle(){
        System.out.println("Please select your user kind:\n" +
                "1. Student (S)\n" +
                "2. Professor (P)\n");
        String type = sc.nextLine();
        switch (type){
            case "1":
                borrowStudent();
                break;
            case "2":
                borrowProfessor();
                break;
        }
    }

    public static void borrowStudent() {
        System.out.println("**********************************");
        System.out.println("\t\tSTUDENT BORROW");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("Please type your DNI: ");
        id = sc.nextLine();
        String user = "S-"+id;
        if   (ids.contains("S-" + id)) {
            for (int i =0; i < ids.size(); i++) {
                String register = ids.get(i);
                if (register.equals("S-" + id)) {
                    number = i;
                }
            }
            System.out.println("**********************************");
            System.out.println("Welcome: " + names.get(number) + ", let's roll!!!");
            System.out.println("**********************************");
        } else {
            System.out.println("User not found, please register or try again");
            boolean menu = true;
        }
        if (debtList.get(number) == true) {
            System.out.println("The user: " + names.get(number) + " has a ticket with debt. Please pay it and try again\n");
            boolean menu = true;
        } else if (debtList.get(number) == false) {
            System.out.println("Select the bicycle's type:\n" +
                    "1. Road\n" +
                    "2. Mountain\n");
            selectType();
        }
    }

    public static void borrowProfessor(){
        System.out.println("**********************************");
        System.out.println("\t\tPROFESSOR BORROW");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("Please type your DNI: ");
        id = sc.nextLine();
        String user = "P-"+id;
        if(ids.contains("P-"+id)){
            for (int i =0; i < ids.size(); i++) {
                String register = ids.get(i);
                if (register.equals("P-" + id)) {
                    number = i;
                }
            }
            System.out.println("**********************************");
            System.out.println("Welcome: " + names.get(number) + ", let's roll!!!");
            System.out.println("**********************************");
        } else {
            System.out.println("User not found, please register or try again");
            boolean menu = true;
        }
        if (debtList.get(number) == true) {
            System.out.println("The user: " + names.get(number) + " has a ticket with debt. Please pay it and try again\n");
            boolean menu = true;
        } else if (debtList.get(number) == false) {
            System.out.println("Select the bicycle's type:\n" +
                    "1. Road\n" +
                    "2. Mountain\n");
            selectType();
        }
    }
    public static void fileReader() throws DAccess {
        TicketHistory.createHistory();
        try {
            impl.readFile("Bicycles.txt", bicyclesData);
        } catch (DReading e) {
            throw new RuntimeException(e);
        }
        for (String bici: bicyclesData) {
            String[] split = bici.split(";");
            for(int i =0; i < split.length; i++) {
                if (split[i].contains("BIC-")) {
                    codes.add(split[i]);
                } else if (split[i].contains("red") || split[i].contains("blue") || split[i].contains("green") | split[i].contains("yellow") || split[i].contains("purple")) {
                    colors.add(split[i]);
                } else if (split[i].contains("Mountain") || split[i].contains("Road")) {
                    types.add(split[i]);
                } else if (split[i].contains("true")) {
                    boolean bool = Boolean.parseBoolean(split[i]);
                    available.add(bool);
                }
            }
        }
        for (int i = 0; i < codes.size(); i++) {
            String code = codes.get(i);
            String type = types.get(i);
            String color = colors.get(i);
            boolean ava = available.get(i);
            Bicycle bicycle = new Bicycle(code,type,color,ava);
            bicycle.setCode(code);
            bicycle.setType(type);
            bicycle.setColor(color);
            bicycle.setAvailable(ava);
            bicycles.add(bicycle);
        }
    }
    public static int randomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }
    public static void selectType(){
        System.out.println("**********************************");
        System.out.println("\tBIKE TYPE SELECTION");
        System.out.println("**********************************");
        System.out.println();
        String option = sc.nextLine();
        switch (option) {
            case "1":
                int i_Random = randomNumber(0,types.size() - 1 );
                String type = types.get(i_Random);
                while (type.equals("Mountain")) {
                    i_Random = randomNumber(0, types.size() - 1);
                    type = types.get(i_Random);
                }
                int j = 0;
                while (available.get(i_Random) == false && j < available.size()) {
                    System.out.println("Please wait while we locate a Road Type Bicycle");
                    j++;
                }
                if (available.get(i_Random) == false) {
                    System.out.println("There are no Road bicycles available. Choose a Mountain one!!!");
                    boolean menu = true;
                } else if (available.get(i_Random) == true) {
                    System.out.println("**********************************");
                    System.out.println("This is your Bike!!!\n" +
                            "Code: " + codes.get(i_Random) + "\n" +
                            "Type: " + types.get(i_Random) + "\n" +
                            "Color: " + colors.get(i_Random) + "\n");
                    System.out.println("**********************************");
                    System.out.println();
                    available.set(i_Random, false);
                    int ticket = Ticket.getCode();
                    for (int i =0; i < ids.size(); i++) {
                        String register = ids.get(i);
                        if (register.equals("S-" + id)) {
                            number = i;
                        } else if (register.equals("P-" + id)){
                            number = i;
                        }
                    }
                    LocalDate date = LocalDate.now();
                    System.out.println("Start time?: \n" +
                            "Hour: ");
                    String ans = sc.nextLine();
                    int hour = Integer.parseInt(ans);
                    System.out.println("Minutes: ");
                    String ans2 = sc.nextLine();
                    int minutes = Integer.parseInt(ans2);
                    LocalTime startTime = LocalTime.of(hour,minutes);
                    LocalTime endTime = null;
                    boolean helmet = true;
                    boolean condition = true;
                    String status = "Active";
                    double amount = 0.0;
                    System.out.println("Ticket generated!!!");
                    Ticket.generateTicket(ticket, codes.get(i_Random), ids.get(number), date,startTime, endTime,helmet, condition, status, amount );
                    TicketHistory.saveTicket(ticket,ids.get(number),names.get(number),amount,status);
                }
                break;
            case "2":
                i_Random = randomNumber(0, types.size() - 1);
                type = types.get(i_Random);
                while (type.equals("Road")) {
                    i_Random = randomNumber(0, types.size() - 1);
                    type = types.get(i_Random);
                }
                j = 0;
                while (available.get(i_Random) == false && j < available.size()) {
                    System.out.println("Please wait while we locate a Mountain Type Bicycle");
                    j++;
                }
                if (available.get(i_Random) == false) {
                    System.out.println("There are no Mountain bicycles available. Choose a Road one!!!");
                    boolean menu = true;
                } else if (available.get(i_Random) == true) {
                    System.out.println("**********************************");
                    System.out.println("Bicycle chosen!\n" +
                            "Code: " + codes.get(i_Random) + "\n" +
                            "Type: " + types.get(i_Random) + "\n" +
                            "Color: " + colors.get(i_Random) + "\n");
                    System.out.println("**********************************");
                    System.out.println();
                    available.set(i_Random, false);
                    int ticket = Ticket.getCode();
                    //int i = ids.indexOf(ids.contains("S-" + id));
                    for (int i =0; i < ids.size(); i++) {
                        String register = ids.get(i);
                        if (register.equals("P-" + id)) {
                            number = i;
                        } else if (register.equals("S-" + id)) {
                            number = i;
                        }
                    }
                    LocalDate date = LocalDate.now();
                    //LocalTime startTime = LocalTime.now();
                    System.out.println("Start time?: \n" +
                            "Hour: ");
                    String ans = sc.nextLine();
                    int hour = Integer.parseInt(ans);
                    System.out.println("Minutes: ");
                    String ans2 = sc.nextLine();
                    int minutes = Integer.parseInt(ans2);
                    LocalTime startTime = LocalTime.of(hour,minutes);
                    LocalTime endTime = null;
                    boolean helmet = true;
                    boolean condition = true;
                    String status = "Active";
                    double amount = 0.0;
                    System.out.println("Ticket generated!!!");
                    Ticket.generateTicket(ticket, codes.get(i_Random), ids.get(number), date,startTime, endTime,helmet, condition, status, amount );
                    TicketHistory.saveTicket(ticket,ids.get(number),names.get(number),amount,status);
                }
                break;
        }
    }
}







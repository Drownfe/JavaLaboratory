package Bicycle;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Data.Accessing;
import Except.DAccess;
import Except.DWriting;

public class TicketHistory {
    private int code;
    private String user;
    private String fullName;
    private double amount;
    private String status;
    static Scanner sc = new Scanner(System.in);
    static Accessing impl = new Accessing();
    static List<TicketHistory> ticketFileList = new ArrayList<>();
    static List<String> header = new ArrayList<>();
    static List<Integer> numberTicketList = new ArrayList<>();
    static List<String> userIDList = new ArrayList<>();
    static List<String> fullnameList = new ArrayList<>();
    static List<Double> amountTicketList = new ArrayList<>();
    static List<String> statusTicketList = new ArrayList<>();
    static List<String> txtReader = new ArrayList<>();
    static int i;
    public TicketHistory(int code, String user, String fullName, double amount, String status) {
        this.code = code;
        this.user = user;
        this.fullName = fullName;
        this.amount = amount;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void createHistory() throws DAccess {

        impl.createFile("tickets.txt");
        header.add("Code");
        header.add("UserID");
        header.add("Name");
        header.add("Amount($)");
        header.add("Status");
    }

    public static void saveTicket(int code, String user, String fullname, double amount, String status){
        code ++;
        TicketHistory ticketFile = new TicketHistory(code,user,fullname,amount,status);
        ticketFile.setCode(code);
        ticketFile.setUser(user);
        ticketFile.setFullName(fullname);
        ticketFile.setAmount(amount);
        ticketFile.setStatus(status);
        ticketFileList.add(ticketFile);
        numberTicketList.add(code);
        userIDList.add(user);
        fullnameList.add(fullname);
        amountTicketList.add(amount);
        statusTicketList.add(status);
        try {
            impl.remove("tickets.txt");
            impl.writeFile("tickets.txt", ticketFileList, true);
        } catch (DWriting e) {
            throw new RuntimeException(e);
        } catch (DAccess e) {
            throw new RuntimeException(e);
        }
    }
    public static void allTickets(){
        File file = new File("tickets.txt");
        try {
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String read;
            while ((read = obj.readLine()) != null ){
                //System.out.println(read);
                txtReader.add(read);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String tickets : txtReader) {
            System.out.println(tickets);
        }
    }
    public static void byCode(){
        File file = new File("tickets.txt");
        try {
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String read;
            while ((read = obj.readLine()) != null ){
                //System.out.println(read);
                txtReader.add(read);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Type the ticket's number: ");
        int code = sc.nextInt();
        for (String tickets : txtReader) {
            if(tickets.contains("T-"+code)){
                System.out.println(tickets);
            }
        }
    }
    public static void byStatus(){
        File file = new File("tickets.txt");
        try {
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String read;
            while ((read = obj.readLine()) != null ){
                //System.out.println(read);
                txtReader.add(read);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Type the status:\n" +
                "1. Active\n" +
                "2. Pending\n" +
                "3. OK ");
        String s = sc.nextLine();
        int st = Integer.parseInt(s);
        String option = null;
        if(st == 1){
            option = "Active";
        }else if (st == 2) {option = "Pending";}
        else if (st == 3) { option = "OK";}
        for (String tickets : txtReader) {
            if(tickets.contains(option)) {
                System.out.println(tickets);
            }
        }
    }
    public static void menuHistory(){
        System.out.println("**************************");
        System.out.println("\tTICKETS HISTORY");
        System.out.println("**************************");
        System.out.println("Select a option:\n" +
                "1. All tickets\n" +
                "2. Search Code\n" +
                "3. Search Status");
        String opt = sc.nextLine();
        int option = Integer.parseInt(opt);
        if (option == 1) {
            System.out.println("All tickets");
            allTickets();
        } else if (option == 2) {
            System.out.println("By code");
            byCode();
        }
        else if (option == 3) {
            System.out.println("By status");
            byStatus();
        }
    }
}

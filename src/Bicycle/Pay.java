package Bicycle;
import Bicycle.Ticket;
import static Bicycle.Ticket.*;
import static User.RegisterUser.ids;
import static Bicycle.TicketHistory.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Pay {
    static Scanner sc = new Scanner(System.in);
    static int code;
    static int i;
    static double amount;
    static String status;
    public static void loadTicket() {
        for (int j =0; j < codes.size(); j++) {
            int register = codes.get(j);
            if (register == code) {
                i= j;
            }
        }
        String  bicycle = bicyclelist.get(i);
        String user = userlist.get(i);
        LocalDate date = dateList.get(i);
        LocalTime starTime = startTimeList.get(i);
        LocalTime endTime = endTimeList.get(i);
        boolean helmet = helmetList.get(i);
        boolean condition = conditionList.get(i);
        amount = amountList.get(i);
        status = statusList.get(i);
        updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        System.out.println("Amount to pay: " + amount + " usd.");
        System.out.println("Please, insert the quantity of usd to pay: ");
        double usd = sc.nextDouble();
        if (usd == amount) {
            System.out.println("Thanks for paying. See you soon");
            status = "OK";
            updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        } else if (usd > amount) {
            System.out.println("Thanks for paying. See you soon");
            double spare = usd - amount;
            System.out.println("You have " + spare + " usd to spare.");
            status = "OK";
            updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        }
        else if(usd<amount){
            System.out.println("Please, insert the correct amount; You must to pay: " + amount + " usd");
        }
    }
    public static void payTicket(){
        System.out.println("Enter ID ticket: ");
        int code = sc.nextInt();
        if (codes.contains(code)) {
            loadTicket();
            String user =userIDList.get(i);
            String fullname = fullnameList.get(i);
            code = code-1;
            TicketHistory.saveTicket(code,user,fullname,amount,status);
        } else {
            System.out.println("Ticket not found, please try again");
            boolean menu = true;
        }
    }
}

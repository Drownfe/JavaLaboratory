package Bicycle;

import static Bicycle.Ticket.*;
import static Bicycle.TicketHistory.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Return {
    static Scanner sc = new Scanner(System.in);
    static String id;
    static boolean helmet;
    static boolean condition;
    static String status;
    static LocalTime endTime;
    static double amount;
    static int code;
    static int i;
    public static void returnBicycle() {
        System.out.println("**********************************");
        System.out.println("\t\tBIKE RETURN");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("What's your ticket number?:\n");
        String nb = sc.nextLine();
        code = Integer.parseInt(nb);
        if (codes.contains(code)) {
            bicycleStatus();
        } else {
            System.out.println("Ticket not found, please try again");
            boolean menu = true;
        }
    }
    public static void bicycleStatus() {
        String ticket = "T-" + code;
        for (int j =0; j < codes.size(); j++) {
            int register = codes.get(j);
            if (register == code) {
                i= j;
            }
        }
        System.out.println("Do you have the helmet? \n" +
                "1. Yes\n" +
                "2. No ");
        String an = sc.nextLine();
        int answer = Integer.parseInt(an);
        helmet = helmetList.get(i);
        if (answer == 1) {
            System.out.println("Helmet in good status");
            helmet = helmetList.get(i);
        } else if (answer == 2) {
            helmet = false;
            System.out.println("Helmet was not returned");
        }
        System.out.println("Helmet status updated");
        
        System.out.println("Is the bicycle in good condition? \n" +
                "1. Yes\n" +
                "2. No ");
        String gd = sc.nextLine();
        int good = Integer.parseInt(gd);
        condition = conditionList.get(i);
        if (good == 1) {
            System.out.println("Bicycle is in good condition");
            condition = conditionList.get(i);
        } else if (good == 2) {
            condition = false;
        }
        System.out.println("Status bicycle condition updated");
        System.out.println("Return time?: \n" +
                "Hour: ");
        String hr = sc.nextLine();
        int hour = Integer.parseInt(hr);
        System.out.println("Minutes: ");
        String mn = sc.nextLine();
        int minutes = Integer.parseInt(mn);
        endTime = LocalTime.of(hour, minutes);
        endTimeList.set(i, endTime);
        status = statusList.get(i);
        String fullname = fullnameList.get(i);
        String bicycle = bicyclelist.get(i);
        String user = userlist.get(i);
        LocalDate date = dateList.get(i);
        LocalTime starTime = startTimeList.get(i);
        amount = 0;
        debtCalculation();
        TicketHistory.saveTicket(code,user,fullname,amount,status);
        System.out.println("Ticket updated!!!");
        updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        amountList.set(i , amount);
        helmetList.set(i, helmet);
        conditionList.set(i,condition);
        statusList.set(i, status);
        bicycleAvailable();
        System.out.println("Proceed payment?: \n" +
                "1. Yes\n" +
                "2. No");
        String py = sc.nextLine();
        int pay = Integer.parseInt(py);
        if (pay == 1) {
            Pay.payTicket();
        } else if (pay == 2) {
            System.out.println("Thank you. Please pay your ticket, come back soon!!!");
        }
    }
    public static void debtCalculation() {
        Duration duration = Duration.between(startTimeList.get(i ), endTimeList.get(i));
        if (duration.toMinutes() > 30) {
            System.out.println("Bicycle was returned: " + duration.toMinutes() + " minutes late.");
            if (helmet == true && condition == true && duration.toMinutes() <30) {
                status = "OK";}
            else {
                status = "Pending";
            }
            double timesLate = Math.floor(duration.toMinutes() / 30);
            double paidLate = timesLate * 3;
            System.out.println("Must to pay " + paidLate + " usd.");
            amount += paidLate;
        }
        if (helmet == false) {
            double paidHelmet = 5.0;
            System.out.println("The bicycle was returned with no helmet, must to pay " + paidHelmet + " usd.");
            amount += paidHelmet;
        }
        if (condition == false) {
            double paidDamaged = 5.0;
            System.out.println("The bicycle was returned damaged, must to pay " + paidDamaged + " usd.");
            amount += paidDamaged;
        }
        System.out.println("Total amount to pay: " + amount + " usd.");
    }
    public static void bicycleAvailable() {
        String bicycleCode = bicyclelist.get(i );
        int position = Borrow.codes.indexOf(bicycleCode);
        Borrow.available.set(position , true);
    }
}

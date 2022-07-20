package Bicycle;
import Data.Accessing;
import Exceptions.DWriting;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class Ticket {
    private static int code;
    private String bicycle;
    private String user;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private boolean helmet;
    private boolean condition;
    private String status;
    static private double amount;
    private String fullName;
    public static List<Ticket> ticketList = new ArrayList<>();
    public static List<Integer> codes = new ArrayList<>();
    public static List<String> bicyclelist = new ArrayList<>();
    public static List<String> userlist = new ArrayList<>();
    public static List<LocalDate> dateList = new ArrayList<>();
    public static List<LocalTime> startTimeList = new ArrayList<>();
    public static List<LocalTime>  endTimeList = new ArrayList<>();
    public static List<Boolean> helmetList = new ArrayList<>();
    public static List<Boolean> conditionList = new ArrayList<>();
    public static List<String> statusList = new ArrayList<>();
    public static List<Double> amountList = new ArrayList<>();
    static Accessing impl = new Accessing();
    public Ticket(int code, String bicycle, String user, LocalDate date, LocalTime start, LocalTime end, boolean helmet, boolean condition, String status, double amount) {
        this.code = code;
        this.bicycle = bicycle;
        this.user = user;
        this.date = date;
        this.start = start;
        this.end = end;
        this.helmet = helmet;
        this.condition = condition;
        this.status = status;
        this.amount = amount;
    }
    public Ticket(int code, String user, String fullName, double amount, String status){
        this.code = code;
        this.user = user;
        this.fullName = fullName;
        this.amount = amount;
        this.status = status;
    }
    public static int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBicycle() {
        return bicycle;
    }

    public void setBicycle(String bicycle) {
        this.bicycle = bicycle;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalTime starTime) {
        this.starTime = starTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isHelmet() {
        return helmet;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

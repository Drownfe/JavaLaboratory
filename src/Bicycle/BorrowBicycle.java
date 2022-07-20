package Bicycle;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BorrowBicycle {

    static Scanner sc = new Scanner(System.in);
    static String id;
    static List<String> bicyclesData = new ArrayList<>();
    public static List<String> codes = new ArrayList<>();
    static List<String> colors = new ArrayList<>();
    static List<String> types = new ArrayList<>();
    static List<Boolean> available = new ArrayList<>();
    static List<Bicycle> bicycles = new ArrayList<>();
    static DataAccessImpl impl = new DataAccessImpl();
    static int number;
}

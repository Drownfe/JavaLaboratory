package Bicycle;


public class Bicycle {
    private String code;
    private String type;
    private String color;
    private boolean isAvailable;

    public Bicycle(String code, String type, String color, boolean isAvailable) {
        this.code = code;
        this.type = type;
        this.color = color;
        this.isAvailable = isAvailable;
    }

    public static void bikes(){
        Bicycle bike1 = new Bicycle("BIC-01","Mountain","red",true);
    }


}

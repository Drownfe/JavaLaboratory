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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

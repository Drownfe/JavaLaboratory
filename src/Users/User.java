package Users;

public class User {
    private String DNI;
    private String name;
    private String surname;
    private int age;
    private String id;


    public User() {
    }

    public User(String DNI, String name, String surname, int age, String id) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

    }
}

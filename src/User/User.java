package User;

public abstract class User {
    private String DNI;
    private String name;
    private String surname;
    private int age;
    private boolean debt;

    public User(String DNI, String name, String surname, int age, boolean debt) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.debt=debt;
        debt = false;
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
        this.age = age;
    }

    public boolean isDebt() {
        return debt;
    }

    public void setDebt(boolean debt) {
        this.debt = debt;
    }
}

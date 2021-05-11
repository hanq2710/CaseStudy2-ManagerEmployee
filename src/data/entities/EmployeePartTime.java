package data.entities;

public class EmployeePartTime extends Employee implements ICalculateSalary {
    private static final long serialVersionUID = 7082765703963201726L;
    private float time;
    private double price;

    public EmployeePartTime(String name, String address, String phone, String email, String cmnd, int age, boolean status, String username, String password, float time, double price) {
        super(name, address, phone, email, cmnd, age, status, username, password);
        this.time = time;
        this.price = price;
    }

    public EmployeePartTime() {
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double calculateSalary() {
        return time * price;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package data.entities;

public class EmployeeFullTime extends Employee implements ICalculateSalary {
    private static final long serialVersionUID = 7082765703963201726L;
    private double salary;
    private double bonus;
    private double penalty;

    public EmployeeFullTime(String name, String address, String phone, String email, String cmnd, int age, boolean status, String username, String password, double salary, double bonus, double penalty) {
        super(name, address, phone, email, cmnd, age, status, username, password);
        this.salary = salary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public EmployeeFullTime(){
        super();
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus - penalty;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

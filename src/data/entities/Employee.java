package data.entities;

import java.io.Serializable;

public abstract class Employee implements Serializable{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String cmnd;
    private int age;
    private boolean status;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(String name, String address, String phone, String email, String cmnd, int age, boolean status, String username, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.cmnd = cmnd;
        this.age = age;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public Employee(){}

    @Override
    public String toString() {
        return  "Tên nhân viên:  "+ name + "  , " +
                "Địa chỉ:  "+ address +"  , " +
                "Số điện thoại:  "+ phone +"  , " +
                "Số CMND:  "+ cmnd +"  , " +
                "Trạng thái:  "+ status;
    }
}

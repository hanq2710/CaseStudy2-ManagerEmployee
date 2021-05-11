package data;

import data.entities.EmployeeFullTime;
import data.entities.EmployeePartTime;

import java.util.ArrayList;


public interface IEmployeePartTimeRepository {

    // Check trùng
    EmployeePartTime getInfoEmployeePartTime(String info);

    // Thêm mới
    void addEmployeePartTime(EmployeePartTime employeePartTime);

    // Sửa
    void updateEmployeePartTime(String cmnd, EmployeePartTime updateEmployeePartTime);

    // Xóa
    void deleteEmployeePartTime(String cmnd);

    // Tìm Kiếm
    EmployeePartTime[] searchEmployeePartTime(String name);

    // Name = mcnd
    String getNameByCmndPartTime(String cmnd);

    // Tính lương PT
    boolean displaySalaryEmployeePartTime(String cmnd);

    // Nhân viên PT đang True
    ArrayList<EmployeePartTime> getEmployeePartTimeTrue();

    // Nhân viên PT đang False
    ArrayList<EmployeePartTime> getEmployeePartTimeFalse();

    // Đôi trạng thái làm việc
    void changeStatusEmployeePartTime(String cmnd, boolean status);






}

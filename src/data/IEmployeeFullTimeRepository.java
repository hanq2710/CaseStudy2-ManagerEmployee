package data;

import data.entities.EmployeeFullTime;

import java.util.ArrayList;

public interface IEmployeeFullTimeRepository {

    // Check thông tin trùng
    EmployeeFullTime getInfoEmployeeFullTime(String info);

    // Thêm mới
    void addEmployeeFullTimes(EmployeeFullTime employeeFullTime);

    // Cập nhật
    void updateEmployeeFullTime(String cmnd, EmployeeFullTime updateEmployeeFullTime);

    //  Xóa
    void deleteEmployee(String cmnd);

    // Hiển thị
    boolean displaySalaryEmployeeFullTime(String cmnd);

    // Tìm kiếm
    EmployeeFullTime[] searchEmployee(String name);

    // Lấy tên = cmnd
    String getNameByCmnd(String cmnd);

    // Trả về nhân viên True
    ArrayList<EmployeeFullTime> getEmployeeFullTimeTrue();

    // Trả về nhân viên False
    ArrayList<EmployeeFullTime> getEmployeeFullTimeFalse();

    //Đôi trạng thái làm việc
    void changeStatusEmployeeFullTime(String cmnd, Boolean status);

}

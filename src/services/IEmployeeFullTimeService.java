package services;

public interface IEmployeeFullTimeService {
    //Thêm mới nhân viên full time
    void addEmployeeFullTime();

    // Cập nhật nhân viên
    void updateEmployeeFullTime();

    // Xóa nhân viên
    void deleteEmployeeFullTime();

    // Hiển thị nhân viên full time đang làm
    void displayEmployeeFullTimeTrue();

    // Hiển thị nhân viên full time đã nghỉ
    void displayEmployeeFullTimeFalse();

    // Tìm kiếm nhân viên:
    void searchEmployeeFullTime();

    // Đổi trạng thái nhân viên
    void changeStatusEmployeeFullTime();

    // Tính lương của nhân viên
    void calculateSalaryFullTime();






}

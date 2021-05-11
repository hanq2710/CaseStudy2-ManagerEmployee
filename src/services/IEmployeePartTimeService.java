package services;

public interface IEmployeePartTimeService {
    //Thêm mới nhân viên full time
    void addEmployeePartTime();

    // Cập nhật nhân viên
    void updateEmployeePartTime();

    // Xóa nhân viên
    void deleteEmployeePartTime();

    //Hiện thị nhân viên part time đang làm
    void displayEmployeePartTimeTrue();

    // Hiển thị nhân viên part time đã nghỉ
    void displayEmployeePartTimeFalse();

    // Tìm kiếm nhân viên:
    void searchEmployeePartTime();

    //Đổi trạng thái nhân viên
    void changeStatusEmployeePartTime();

    // Tính lương của nhân viên
    void calculateSalaryPartTime();






}

package services;

import data.IEmployeePartTimeRepository;
import data.entities.EmployeePartTime;

import java.util.Scanner;

public class EmployeePartTimeService extends BaseEmployeeService implements IEmployeePartTimeService{
    private final IEmployeePartTimeRepository employeePartTimeRepository;

    public EmployeePartTimeService(IEmployeePartTimeRepository employeePartTimeRepository) {
        this.employeePartTimeRepository = employeePartTimeRepository;
    }

    public float writeTime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập giờ làm: ");
        return sc.nextFloat();
    }
    public double writePrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền 1 giờ: ");
        return sc.nextDouble();
    }
    //Thêm nhân viên
    public EmployeePartTime writeEmployeePartTime() {
        EmployeePartTime newEmployeePartTime = new EmployeePartTime();

        String name = writeName();
        newEmployeePartTime.setName(name);

        String address = writeAddress();
        newEmployeePartTime.setAddress(address);

        String phone = writePhoneEmployeePartTime();
        newEmployeePartTime.setPhone("+" + phone);

        String email = writeEmail();
        newEmployeePartTime.setEmail(email);

        String cmnd = writeCmndEmployeePartTime();
        newEmployeePartTime.setCmnd(cmnd);

        newEmployeePartTime.setAge(writeAge());

        newEmployeePartTime.setStatus(writeStatus());

        newEmployeePartTime.setTime(writeTime());

        newEmployeePartTime.setPrice(writePrice());

        return newEmployeePartTime;
    }

    // Thêm nhân viên
    @Override
    public void addEmployeePartTime(){
        employeePartTimeRepository.addEmployeePartTime(writeEmployeePartTime());
    }

    // Cập nhật nhân viên
    @Override
    public void updateEmployeePartTime() {
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            System.out.println("Nhập số chứng minh nhân dân của nhân viên muốn sửa: ");
            cmnd = sc.nextLine();
            check = checkInfoEmployeePartTime(cmnd);
            if (check) System.err.println("Số chứng minh nhân dân không tồn tại..! --- Vui lòng nhập lại: ");
        } while (!check);
        System.out.println("Accept..!");
        System.out.println("Bạn đang cập nhật nhân viên: -" + employeePartTimeRepository.getNameByCmndPartTime(cmnd)
                + "- với định danh cmnd là: " + cmnd);
        employeePartTimeRepository.updateEmployeePartTime(cmnd, writeEmployeePartTime());
    }

    //Xóa nhân viên
    @Override
    public void deleteEmployeePartTime() {
        System.out.println("Nhập vào số chứng minh nhân dân của nhân viên muốn xóa: ");
        Scanner  sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            cmnd = sc.nextLine();
            check = checkInfoEmployeePartTime(cmnd);
            if (check) System.err.println("Số chứng minh nhân dân không tồn tại..! --- Vui lòng nhập lại: ");
        } while (check);
        System.out.println("Bạn đang xóa nhân viên -" +
                employeePartTimeRepository.getNameByCmndPartTime(cmnd) +
                "- với số chứng mình là: " + cmnd);
        employeePartTimeRepository.deleteEmployeePartTime(cmnd);
    }

    // Hiển thị nhân viên part time đang làm
    @Override
    public void displayEmployeePartTimeTrue() {
        for (EmployeePartTime t: employeePartTimeRepository.getEmployeePartTimeTrue()
             ) {
            System.out.printf("\n\t\t\t\t\t%10s",t + "\n");
        }
    }

    // Hiển thị nhân viên part time đang nghỉ
    @Override
    public void displayEmployeePartTimeFalse() {
        for (EmployeePartTime f: employeePartTimeRepository.getEmployeePartTimeFalse()
             ) {
            System.out.printf("\n\t\t\t\t\t%10s",f + "\n");
        }
    }

    // Tìm kiếm nhân viên:
    @Override
    public void searchEmployeePartTime(){
        EmployeePartTime[] employeePartTimes;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập tên nhân viên:  ");
            String name = sc.nextLine();
            employeePartTimes = employeePartTimeRepository.searchEmployeePartTime(name);
            if(employeePartTimes.length == 0) System.err.println("Nhân viên không tồn tại..! - Vui lòng nhập lại: ");
        }  while(employeePartTimes.length == 0);
        for (EmployeePartTime emp: employeePartTimes
        ) {
            System.out.printf("\n\t\t\t\t\t%10s","Tên nhân viên: " + emp.getName() +
                    ", Địa chỉ: " + emp.getAddress() +
                    ", SĐT: " + emp.getPhone() +
                    ", Email: " + emp.getEmail() +
                    ", Số CMND: " + emp.getCmnd() +
                    ", Tuổi: " + emp.getAge() +
                    ", Trạng thái: " + emp.isStatus() +
                    ", Lương cứng: " + emp.getTime() +
                    ", Lương thưởng: " + emp.getPrice() + "\n");
        }
    }

    @Override
    public void changeStatusEmployeePartTime() {
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            System.out.println("Nhập số chứng minh của nhân viên: ");
            cmnd = sc.nextLine();
            check = checkInfoEmployeePartTime(cmnd);
            if(check) System.out.println("Số chứng minh nhân dân không tồn tại..!");
        }while (check);
        System.out.println("Accept..!");
        System.out.println("Bạn đang cập nhật trạng thái của nhân viên: "
                + employeePartTimeRepository.getNameByCmndPartTime(cmnd)
                + " với định danh cmnd là: " + cmnd);
        employeePartTimeRepository.changeStatusEmployeePartTime(cmnd,writeStatus());
        System.out.println("Cập nhật thành công..!");
    }
    // Tính lương của nhân viên
    @Override
    public void calculateSalaryPartTime(){
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            System.out.println("Nhập số chứng minh nhân dân của nhân viên: ");
            cmnd = sc.nextLine();
            check = employeePartTimeRepository.displaySalaryEmployeePartTime(cmnd);
            if(!check) System.err.println("Số chứng minh nhân dân không tồn tại --- Vui lòng nhập lại: ");
        }while (!check);
    }






}


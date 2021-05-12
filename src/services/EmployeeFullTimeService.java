package services;

import data.IEmployeeFullTimeRepository;
import data.entities.EmployeeFullTime;

import java.util.Scanner;

public class EmployeeFullTimeService extends BaseEmployeeService implements IEmployeeFullTimeService{
    private final IEmployeeFullTimeRepository employeeFullTimeRepository;

    public EmployeeFullTimeService(IEmployeeFullTimeRepository employeeFullTimeRepository) {
        this.employeeFullTimeRepository = employeeFullTimeRepository;
    }

    private final Scanner SCANNER = new Scanner(System.in);

    public double writeSalary(){
        System.out.println("Nhập lương cứng: ");
        double salary = SCANNER.nextDouble();
        if(salary == 0){
            salary = 8000000;
        }
        return salary;
    }
    private double writeBonus(){
        System.out.println("Nhập tiền thưởng: ");
        return SCANNER.nextDouble();
    }
    private double writePenalty(){
        System.out.println("Nháp tiền phạt: ");
        return SCANNER.nextDouble();
    }
    //Thêm nhân viên
    public EmployeeFullTime writeEmployeeFullTime() {
        EmployeeFullTime newEmployeeFullTime = new EmployeeFullTime();

        String name = writeName();
        newEmployeeFullTime.setName(name);

        String address = writeAddress();
        newEmployeeFullTime.setAddress(address);

        String phone = writePhoneEmployeeFullTime();
        newEmployeeFullTime.setPhone("+" + phone);

        String email = writeEmail();
        newEmployeeFullTime.setEmail(email);

        String cmnd = writeCmndEmployeeFullTime();
        newEmployeeFullTime.setCmnd(cmnd);

        newEmployeeFullTime.setAge(writeAge());

        newEmployeeFullTime.setStatus(writeStatus());
        newEmployeeFullTime.setSalary(writeSalary());
        newEmployeeFullTime.setBonus(writeBonus());
        newEmployeeFullTime.setPenalty(writePenalty());
        return newEmployeeFullTime;
    }
    // Thêm nhân viên full time
    public void addEmployeeFullTime(){
        employeeFullTimeRepository.addEmployeeFullTimes(writeEmployeeFullTime());
    }
    // Cập nhật nhân viên
    @Override
    public void updateEmployeeFullTime() {
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            System.out.println("Nhập số chứng minh nhân dân của nhân viên muốn sửa: ");
            cmnd = sc.nextLine();
            check = checkInfoEmployeeFullTime(cmnd);
            if (check) System.err.println("Số chứng minh nhân dân không tồn tại --- Vui lòng nhập lại: ");
        } while (check);
        System.out.println("Accept..!");
        System.out.println("Bạn đang cập nhật nhân viên "
                + employeeFullTimeRepository.getNameByCmnd(cmnd)
                + " với định danh cmnd là: " + cmnd);
        employeeFullTimeRepository.updateEmployeeFullTime(cmnd, writeEmployeeFullTime());
    }
    // Xóa nhân viên
    @Override
    public void deleteEmployeeFullTime() {
        System.out.println("Nhập vào số chứng minh nhân dân của nhân viên muốn xóa: ");
        Scanner  sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            cmnd = sc.nextLine();
            check = checkInfoEmployeeFullTime(cmnd);
            if (check) System.err.println("Số chứng minh nhân dân không tồn tại --- Vui lòng nhập lại: ");
        } while (check);
        System.out.println("Bạn đang xóa nhân viên " +
                employeeFullTimeRepository.getNameByCmnd(cmnd) +
                " với số chứng mình là: " + cmnd);
        employeeFullTimeRepository.deleteEmployeeFullTime(cmnd);
    }

    // Hiển thị nhân viên full time đang làm

    public void displayEmployeeFullTimeTrue() {
        for (EmployeeFullTime e: employeeFullTimeRepository.getEmployeeFullTimeTrue()
             ) {
            System.out.printf("\n\t\t\t\t\t%10s",e + "\n");
        }
    }
    // Hiển thị nhân viên full time đã nghỉ
    @Override
    public void displayEmployeeFullTimeFalse() {
        for (EmployeeFullTime e:employeeFullTimeRepository.getEmployeeFullTimeFalse()
             ) {
            System.out.printf("\n\t\t\t\t\t%20s",e + "\n");
        }
    }
    // Tìm kiếm nhân viên:
    @Override
    public void searchEmployeeFullTime(){
        EmployeeFullTime [] employeeFullTimes;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhâp tên nhân viên: ");
            String name = sc.nextLine();
            employeeFullTimes = employeeFullTimeRepository.searchEmployeeFullTime(name);
            if(employeeFullTimes.length == 0) System.err.println("Nhân viên không tồn tại..! - Vui lòng nhập lại: ");
        }  while(employeeFullTimes.length == 0);
        System.out.println("Tìm kiếm thành công..!");
        for (EmployeeFullTime emp: employeeFullTimes
        ) {
            System.out.printf("\n\t\t\t\t\t%10s","Tên nhân viên: " + emp.getName() +
                    ", Địa chỉ: " + emp.getAddress() +
                    ", SĐT: " + emp.getPhone() +
                    ", Email: " + emp.getEmail() +
                    ", Số CMND: " + emp.getCmnd() +
                    ", Tuổi: " + emp.getAge() +
                    ", Trạng thái: " + emp.isStatus() +
                    ", Lương cứng: " + emp.getSalary() +
                    ", Lương thưởng: " + emp.getBonus() +
                    ", Tiền phạt: " + emp.getPenalty() + "\n");
        }
    }
    // Chọn trạng tháu làm việc
    @Override
    public void changeStatusEmployeeFullTime() {
       Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            System.out.println("Nhập số chứng minh của nhân viên: ");
            cmnd = sc.nextLine();
            check = checkInfoEmployeeFullTime(cmnd);
            if(check) System.out.println("Số chứng minh nhân dân không tồn tại..!");
        }while (check);
        System.out.println("Accept..!");
        System.out.println("Bạn đang cập nhật trạng thái của nhân viên: "
                + employeeFullTimeRepository.getNameByCmnd(cmnd)
                + " với định danh cmnd là: " + cmnd);
        employeeFullTimeRepository.changeStatusEmployeeFullTime(cmnd,writeStatus());
    }

    // Tính lương của nhân viên
    @Override
    public void calculateSalaryFullTime(){
        Scanner sc = new Scanner(System.in);
        String cmnd;
        boolean check;
        do {
            System.out.println("Nhập số chứng minh nhân dân của nhân viên: ");
            cmnd = sc.nextLine();
            check = employeeFullTimeRepository.displaySalaryEmployeeFullTime(cmnd);
            if(!check) System.out.println("Số chứng minh nhân dân không tồn tại --- Vui lòng nhập lại: ");
        }while (!check);
    }
}

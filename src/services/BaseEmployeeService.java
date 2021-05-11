package services;

import data.EmployeeFullTimeRepository;
import data.EmployeePartTimeRepository;
import data.IEmployeeFullTimeRepository;
import data.IEmployeePartTimeRepository;

import java.util.Scanner;

public class BaseEmployeeService {
    IEmployeeFullTimeRepository employeeFullTimeRepository = new EmployeeFullTimeRepository();
    IEmployeePartTimeRepository employeePartTimeRepository = new EmployeePartTimeRepository();
    //Phương thức đặt thuộc tính của nhân viên
        public String writeName(){
            Scanner sc = new Scanner(System.in);
            boolean checkRegexName;
            String name;
            do {
                System.out.println("Nhập tên nhân viên: ");
                name = sc.nextLine();
                checkRegexName = regexName(name);
            } while (!checkRegexName);
            return name;

        }

        public String writeAddress(){
            Scanner sc = new Scanner(System.in);
            String address;
            do {
                System.out.println("Nhập địa chỉ: ");
                address = sc.nextLine();
                if (address.equals("")) {
                System.err.println("Không được để trống mục này..! --- Please enter: ");
            }
        } while (address.equals(""));
            return address;
        }


        public String writePhoneEmployeeFullTime(){
            Scanner sc = new Scanner(System.in);
            String phone;
            boolean checkPhone;
            boolean checkRegexPhone;
            do {
                System.out.println("Nhập số điện thoại: ");
                System.out.println("Mẫu :// 85-990-8989");
                phone = sc.nextLine();
                checkPhone = checkInfoEmployeeFullTime(phone);
                if (!checkPhone) System.err.println("Số điện thoại đã tồn tại..! --- Vui lòng nhập lại ");
                checkRegexPhone = regexPhone(phone);
        } while (!checkPhone || !checkRegexPhone);
            return phone;
        }

        public String writePhoneEmployeePartTime(){
            Scanner sc = new Scanner(System.in);
            String phone;
            boolean checkPhone;
            boolean checkRegexPhone;
            do {
                System.out.println("Nhập số điện thoại: ");
                System.out.println("Mẫu :// 85-990-8989");
                phone = sc.nextLine();
                checkPhone = checkInfoEmployeePartTime(phone);
                if (!checkPhone) System.err.println("Số điện thoại đã tồn tại..! --- Vui lòng nhập lại ");
                checkRegexPhone = regexPhone(phone);
        } while (!checkPhone || !checkRegexPhone);
            return phone;
        }
        public String writeEmail(){
            Scanner sc = new Scanner( System.in);
            boolean checkRegexEmail;
            String email;
            do {
                System.out.println("Nhập email: ");
                System.out.println("Mẫu :// demo@gmail.com ");
                email = sc.nextLine();
                checkRegexEmail = regexEmail(email);
            } while (!checkRegexEmail);
            return email;
        }

        public String writeCmndEmployeeFullTime(){
            Scanner sc = new Scanner(System.in);
            boolean checkCmnd;
            boolean checkRegexCmnd;
            String cmnd;
            do {
                System.out.println("Nhập số Cmnd: ");
                cmnd = sc.nextLine();
                checkCmnd = checkInfoEmployeeFullTime(cmnd);
                if (!checkCmnd) System.err.println("Số chứng minh nhân dân đã tồn tại..! --- Vui lòng nhập lại: ");
                checkRegexCmnd = regexCmnd(cmnd);
            } while (!checkCmnd || !checkRegexCmnd);
            return cmnd;
        }

        public String writeCmndEmployeePartTime(){
            Scanner sc = new Scanner(System.in);
            boolean checkCmnd;
            boolean checkRegexCmnd;
            String cmnd;
            do {
                System.out.println("Nhập số Cmnd: ");
                cmnd = sc.nextLine();
                checkCmnd = checkInfoEmployeePartTime(cmnd);
                if (!checkCmnd) System.err.println("Số chứng minh nhân dân đã tồn tại..! --- Vui lòng nhập lại: ");
                checkRegexCmnd = regexCmnd(cmnd);
            } while (!checkCmnd || !checkRegexCmnd);
            return cmnd;
        }

        public int writeAge(){
            Scanner age = new Scanner(System.in);
            System.out.println("Nhập tuổi: ");
            while(!age.hasNextInt())
            {
                age = new Scanner(System.in);
                System.err.println("Nhập đúng số tuổi bằng số nguyên ..!--- Vui lòng nhập lại: ");
                System.out.println("Nhập tuổi: ");
            }
            return age.nextInt();
        }

    //Regex định dạng các trường dữ liệu đầu vào
    public boolean regexName (String name){
        String regexName = "^[a-zA-Z]+[\\-'\\s]*[a-zA-Z ]+$";
        if(name.matches(regexName)) return true;
        else {
            System.err.println("Định dạng không đúng..! --- Vui lòng nhập lại: ");
            return false;
        }
    }
    public boolean regexPhone(String phone){
        String regexPhone  = "^\\d{2}-\\d{3}-\\d{4}$";
        if(phone.matches(regexPhone)) return true;
        else {
            System.err.println("Định dạng không đúng..! --- Vui lòng nhập lại: ");
            return false;
        }
    }
    public boolean regexEmail(String email){
        String regexEmail =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if(email.matches(regexEmail)) return true;
        else {
            System.err.println("Định dạng không đúng..! --- Vui lòng nhập lại: ");
            return false;
        }
    }
    public boolean regexCmnd(String cmnd){
        String regexCmnd  = "^\\d{9}$";
        if(cmnd.matches(regexCmnd)) return true;
        else {
            System.err.println("Định dạng không đúng..! ---  Vui lòng nhập lại: ");
            return false;
        }
    }

    public Boolean checkInfoEmployeeFullTime(String info){
        return employeeFullTimeRepository.getInfoEmployeeFullTime(info) == null;
    }

    public Boolean checkInfoEmployeePartTime(String info){
        return employeePartTimeRepository.getInfoEmployeePartTime(info) == null;
    }

        public boolean writeStatus(){
            Scanner stt = new Scanner(System.in);
            System.out.println("Chọn trạng thái: " + "\n" + "Number 1 = Đang làm." + "\n" + "Number 2 = Đang nghỉ");
            switch (stt.nextInt()){
                case 1:
                    return true;
                case 2:
                    return false;
                case 0:
                    System.exit(0);
            }
            return true;
        }
}

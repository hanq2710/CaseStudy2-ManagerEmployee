package services;

import data.AccountRepository;
import data.IAccountRepository;
import data.entities.Account;

import java.util.Scanner;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountService(){
        this.accountRepository = new AccountRepository();
    }
    // Đăng nhập
    public boolean loginUser() {
        Account account;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        boolean check = false;
        int count = 0;
        String username;
        String password;
        do {
            System.out.println("Nhập tài khoản người dùng: ");
            username = sc.nextLine();
            System.out.println("Nhập mật khẩu: ");
            password = sc1.nextLine();
            account = accountRepository.getByUsernameAndPassword(username,password);
            if(account != null) {
                check = true;
            }else {
                count++;
            }
            if (count == 1 && account == null) {
                System.out.println("..............Checking..!...........!");
                System.out.println("Tài khoản hoặc người dùng không đúng, vui lòng nhập lại");
                System.out.println("---Còn  2 lần nhập..!---");
            } else if( count == 2 && account == null) {
                System.out.println("..............Checking..!...........!");
                System.out.println("Tài khoản hoặc người dùng không đúng, vui lòng nhập lại");
                System.out.println("---Còn 1 lần nhập ..!---");
            }else if(count > 2)break;
        }while (!check);
            if(count == 3){
                System.out.println("Tài khoản mật khẩu không đúng --- Tạm biệt!");
                System.exit(0);
            } else{
                System.out.println("..............Checking..!...........!");
                System.out.println("Accept!!!");
            }
        System.out.println("Xin chào " + username + " <3..!");
            return adminCheck(username, password);
    }
    //Kiểm tra username đã tồn tại chưa
    public boolean checkInfo(String info) {
        if(accountRepository.getByUsername(info) == null) return true;
        return false;
    }
    // Nhập email
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
    public boolean regexEmail(String email){
        String regexEmail =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if(email.matches(regexEmail)) return true;
        else {
            System.err.println("Định dạng không đúng..! --- Vui lòng nhập lại: ");
            return false;
        }
    }

    // Đăng ký tài khoản
    public void creatAccount(){
        Scanner sc = new Scanner(System.in);
        Account newAccount = new Account();
        String newUsername;
        boolean check = false;
        do {
            System.out.println("Nhập tên người dùng: ");
            newUsername = sc.nextLine();
            check = checkInfo(newUsername);
            if(!check) System.err.println("Tên người dùng đã tồn tại --- Vui lòng nhập lại");
        }while (!check);
        newAccount.setUsername(newUsername);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập mật khẩu: ");
        newAccount.setPassword(sc1.nextLine());
        newAccount.setEmail(writeEmail());
        accountRepository.addAccount(newAccount);
    }
    // Đổi mật khẩu
    public void changePassword(){
        Scanner sc =  new Scanner(System.in);
        String password;
        boolean check = false;
        do {
            System.out.println("Nhập mật khẩu hiện tại: ");
            password  = sc.nextLine();
            if(accountRepository.getByPassword(password) != null)
            {
                check = true;
            }
            else {
                System.err.println("Mật khẩu sai..! --- Vui lòng nhập lại.");
            }
        }while (!check);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập mật khẩu mới: ");
        accountRepository.changePassword(password,sc1.nextLine());
    }
    // Lấy lại mật khẩu
    public void forgotPassword(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String username;
        String email;
        boolean checkUsername = true;
        boolean checkEmail = false;
        do {
            System.out.println("Nhâp tên người dùng: ");
            username = sc.nextLine();
            email = writeEmail();
            checkUsername = checkInfo(username);
            if(accountRepository.getByEmail(email) == null) checkEmail = true;
            if(checkEmail || checkUsername) System.err.println("Tên người dùng hoặc email không đúng --- Vui Lòng nhập lại.");
        }while (checkEmail || checkUsername);
        System.out.println("Mật khẩu của user " + username + " là: " );
        accountRepository.forgotPassword(username,email);
    }
    public boolean adminCheck(String username , String password){
        if(username.equals("admin") && password.equals("admin")) return true;
        else return false;
    }
}

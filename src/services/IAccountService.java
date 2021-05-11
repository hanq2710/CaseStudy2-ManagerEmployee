package services;

public interface IAccountService {
    // Đăng nhập
    boolean loginUser();

    //Đăng ký
    void creatAccount();

    // Đổi mật khẩu
    void changePassword();

    // Lấy lại mật khẩu
    void forgotPassword();
}

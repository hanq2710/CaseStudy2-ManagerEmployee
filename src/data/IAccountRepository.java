package data;

import data.entities.Account;

public interface IAccountRepository {
    Account getByUsernameAndPassword(String username, String password);

    Account getByUsername(String username);

    Account getByPassword(String password);

    Account getByEmail(String email);

    void addAccount(Account account);

    void changePassword(String password, String newPassword);

    void forgotPassword(String username, String email);
}

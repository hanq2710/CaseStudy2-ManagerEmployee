package data;

import data.entities.Account;

import java.io.Serializable;
import java.util.ArrayList;


public class AccountRepository implements Serializable, IAccountRepository {
    // Đọc file
    FacetoryFile facetoryFile;
    ArrayList<Account> accounts;
    public AccountRepository(){
        facetoryFile = new FacetoryFile();
        accounts= facetoryFile.readFile("account.data.txt");
    }
    @Override
    public Account getByUsernameAndPassword(String username, String password){
        return accounts.stream().filter(
                s -> username.equals(s.getUsername()) &&
                        password.equals(s.getPassword())).findFirst().orElse(null);
    }
    @Override
    public Account getByUsername(String username){
        return accounts.stream().filter(
                o -> username.equals(o.getUsername())).findFirst().orElse(null);
    }
    @Override
    public Account getByPassword(String password){
        return accounts.stream().filter(
                o -> password.equals(o.getPassword())).findFirst().orElse(null);
    }
    @Override
    public Account getByEmail(String email){
        return accounts.stream().filter(
                o -> email.equals(o.getEmail())).findFirst().orElse(null);
    }
    @Override
    public void addAccount(Account account){
        accounts.add(account);
        facetoryFile.writeContact("account.data.txt",accounts);
        System.out.println("Đăng ký thành công..!");
    }
    @Override
    public void changePassword(String password, String newPassword){
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getPassword().equals(password)){
                accounts.get(i).setPassword(newPassword);
                facetoryFile.writeContact("account.data.txt",accounts);
                System.out.println("Thay đổi thành công ..!");
                break;
            }
        }
    }
    @Override
    public void forgotPassword(String username, String email){
        Account account = new Account();
        account = accounts.stream().filter(
                o -> username.equals(o.getUsername()) && email.equals(o.getEmail())).findFirst().orElse(null);
        if(account != null) System.out.println(account.getPassword());
    }
}

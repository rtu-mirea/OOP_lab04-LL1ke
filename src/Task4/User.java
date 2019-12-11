package Task4;


import java.util.Scanner;
import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private String login;
    private String password;

    User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    User(){
        name = "";
        login = "";
        password = "";
    }

    public boolean enter(String login, String password){
        if (this.login.equals(login) && this.password.equals(password))
            return true;
        return false;
    }

    public String toString(){
        return name + " " + login + " " + password;
    }

    public void vvodsconsoli (){
        Scanner i = new Scanner(System.in);
        name = i.next();
        login = i. next();
        password = i.next();
    }

    public String getName() {
        return name;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

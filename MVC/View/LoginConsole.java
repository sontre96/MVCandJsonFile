package jdbcapp.MVC.View;

import jdbcapp.MVC.Controller.LoginController;
import jdbcapp.MVC.Entity.Users;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginConsole {
    //step1:
    LoginController loginController = new LoginController();
    Users users = new Users();

    private final Scanner sc;

    public LoginConsole() {
        this.sc = new Scanner(System.in);
    }
    //C1:
    public int menu(){
        System.out.println("======LOGIN==========");
        System.out.println("1. Login Statament");
        System.out.println("2. Login Preparared statement");
        System.out.println("3. Exit");
        int choice = readInt(0,3);
        return choice;
    }

    public void start() throws SQLException, ClassNotFoundException {
        while (true){
            int choice;
            choice = menu();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    loginStatement();
                    break;
                case 2:
                    loginPrepararedStatement();
                    break;
                default:
                    System.out.println("Exit!!!!!");
                    System.exit(3);
                    break;
            }
        }
    }

    public int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return choice;
    }

    public void loginStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        users.setUsername(username);
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        users.setPassword(password);
        loginController.loginStatementController(users);

    }

    public void loginPrepararedStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        users.setUsername(username);
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        users.setPassword(password);
        loginController.loginPrepararedStatementController(users);
    }



}

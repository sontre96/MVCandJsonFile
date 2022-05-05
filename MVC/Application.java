package jdbcapp.MVC;

import jdbcapp.MVC.View.EmployeeConsole;
import jdbcapp.MVC.View.LoginConsole;
import jdbcapp.MVC.View.ProductConsole;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        LoginConsole loginConsole = new LoginConsole();
//        loginConsole.start();

//        EmployeeConsole employeeConsole = new EmployeeConsole();
//        employeeConsole.showMenu();

        ProductConsole productConsole = new ProductConsole();
        productConsole.showMenu();
    }
}

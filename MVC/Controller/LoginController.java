package jdbcapp.MVC.Controller;

import jdbcapp.MVC.Entity.Users;
import jdbcapp.MVC.Model.Login.LoginDAOImpl;

import java.sql.SQLException;

public class LoginController {
    LoginDAOImpl loginDAO = new LoginDAOImpl();

    public String loginStatementController(Users users) throws SQLException, ClassNotFoundException {
        //Step 2:
        return loginDAO.checkLoginStatement(users);
    }

    public String loginPrepararedStatementController(Users users) throws SQLException, ClassNotFoundException {
        return loginDAO.checkLoginPrepararedStatement(users);
    }


}

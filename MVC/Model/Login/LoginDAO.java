package jdbcapp.MVC.Model.Login;

import jdbcapp.MVC.Entity.Users;

import java.sql.SQLException;

public interface LoginDAO  {
    public String checkLoginStatement(Users users) throws SQLException, ClassNotFoundException;

    public String checkLoginPrepararedStatement(Users users) throws SQLException, ClassNotFoundException;
}

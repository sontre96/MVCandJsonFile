package jdbcapp.MVC.Model.Login;


import jdbcapp.MVC.DAO.SQLServerConnection;
import jdbcapp.MVC.Entity.Users;
import jdbcapp.MVC.Model.Login.LoginDAO;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public String checkLoginStatement(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "select username from users where username = '" +users.getUsername()+"'"
                +"and password= '"+users.getPassword()+"'";


        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("login thanh cong "+ resultSet.getString("username"));
            return  users.getUsername();
        }
        return "fail";
    }

    @Override
    public String checkLoginPrepararedStatement(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "select username from users where username =? and password =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, users.getUsername());
        preparedStatement.setString(2, users.getPassword());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Login Thanh Cong: " + resultSet.getString("username"));
            return users.getUsername();
        }
        return "Login Failed";

    }
}

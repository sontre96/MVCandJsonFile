package jdbcapp.MVC.Model.Product;

import jdbcapp.MVC.DAO.SQLServerConnection;
import jdbcapp.MVC.Entity.Product;
import jdbcapp.MVC.Model.Product.ProductDAO;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "insert into product(proName,proDesc,price) values(?,?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, product.getProName());
        preparedStatement.setString(2, product.getProDesc());
        preparedStatement.setDouble(3, product.getPrice());

        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            product.setId(resultSet.getInt(1));
        }
    }

    @Override
    public Product getProductById(int id) throws SQLException, ClassNotFoundException {
        Product product = new Product();

        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "select * from product where id = ? ";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            product.setId(resultSet.getInt(1));
            product.setProName(resultSet.getString(2));
            product.setProDesc(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
        }
        return product;
    }

    @Override
    public ArrayList<Product> getProductByName(String name) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        ArrayList<Product> productList = new ArrayList<>();
        String query = "select * from product where proName = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt(1));
            product.setProName(resultSet.getString(2));
            product.setProDesc(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
        }
        return productList;
    }

    @Override
    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query = "select * from product";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Product> allProduct = new ArrayList<>();
        while (resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getInt(1));
            product.setProName(resultSet.getString(2));
            product.setProDesc(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
            allProduct.add(product);
        }
        return allProduct;
    }

    @Override
    public void updateProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        //Search product by Id
        String query = "update product set proName =?, proDESC =?, price =? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getProName());
        preparedStatement.setString(2, product.getProDesc());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String query = "delete from product where id = ?" ;
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        return true;
    }


}

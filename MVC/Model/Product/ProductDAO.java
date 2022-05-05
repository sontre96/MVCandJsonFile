package jdbcapp.MVC.Model.Product;

import jdbcapp.MVC.Entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    public void createProduct(Product product) throws SQLException, ClassNotFoundException;

    public Product getProductById(int id) throws SQLException, ClassNotFoundException;

    public ArrayList<Product> getProductByName(String name)  throws SQLException, ClassNotFoundException;//loi

    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException;

    public void updateProduct(Product product) throws SQLException, ClassNotFoundException;

    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;

}

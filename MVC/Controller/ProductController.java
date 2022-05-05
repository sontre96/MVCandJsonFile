package jdbcapp.MVC.Controller;

import jdbcapp.MVC.Entity.Product;
import jdbcapp.MVC.Model.Product.ProductDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductDAOImpl productDAO = new ProductDAOImpl();

    public void createProductController(Product product) throws SQLException, ClassNotFoundException {
        productDAO.createProduct(product);
    }

    public Product getProductByIdController(int id)throws SQLException, ClassNotFoundException{
        Product product = productDAO.getProductById(id);
        return  product;
    }

    public ArrayList<Product> getProductByNameController(String name) throws SQLException, ClassNotFoundException {
        ArrayList<Product> products = productDAO.getProductByName(name);
        return products;
    }

    public ArrayList<Product> getAllProductController() throws SQLException, ClassNotFoundException {
        ArrayList<Product> allproduct = productDAO.getAllProduct();
        return allproduct;

    }

    public void updateProductController(Product product)throws SQLException, ClassNotFoundException{
        productDAO.updateProduct(product);
    }

    public boolean deleteProdutController(int id)throws SQLException, ClassNotFoundException{
        boolean result = productDAO.deleteProduct(id);
        return  result;
    }

}

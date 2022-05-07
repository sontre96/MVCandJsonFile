package jdbcapp.MVC.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import jdbcapp.MVC.Controller.ProductController;
import jdbcapp.MVC.DAO.SQLServerConnection;
import jdbcapp.MVC.Entity.Product;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductConsole {
    ProductController productController = new ProductController();
    Product product = new Product();

    private final Scanner sc;

    public ProductConsole() throws SQLException, ClassNotFoundException {
        this.sc = new Scanner(System.in);
    }

    //C2:
    public void Menu(){
        System.out.println("======Product=====");
        System.out.println("1. Create a new product ");
        System.out.println("2. Search Product by Id");
        System.out.println("3. Search Product by Name");
        System.out.println("4. Display all Product");
        System.out.println("5. Update a Product by Id");
        System.out.println("6. Delete a Product by Id");
        System.out.println("7. Export product to Json file ");
        System.out.println("8. Read JSon file");
        System.out.println("9. Exit!!!");
        System.out.println("Choose: ");
    }

    public void showMenu() throws SQLException, ClassNotFoundException, IOException {
        int choose;

        do {
            Menu();
            choose = Integer.parseInt(sc.nextLine());

            switch (choose){
                case 1:
                    createProduct();
                    break;
                case 2:
                    getProductById();
                    break;
                case 3:
                    getProductByName();
                    break;
                case 4:
                    getAllProduct();
                    break;
                case 5:
                    getProductById();
                    updateProduct();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 7:
                    ExportToJsonFile();
                    break;
                case 8:
                    ReadFileJSon();
                    break;
                case 9:
                    Connection connection = SQLServerConnection.getSQLServerConnection();
                    connection.close();
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("Enter fail; Please choose agian!!!");
                    break;
            }
        }while (choose!=9);
    }

    public void createProduct() throws SQLException, ClassNotFoundException {
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product Description: ");
        String desc = sc.nextLine();
        System.out.println("Enter product price:");
        Double price = Double.parseDouble(sc.nextLine());

        Product product = new Product(name,desc,price);
        //step 4
        productController.createProductController(product);
        System.out.println("--------------------------------------");
        System.out.println("Insert product id number: " +product.getId());
    }

    public void getProductById() throws SQLException, ClassNotFoundException{
        //step1
        System.out.println("Enter Id:");
        int id = Integer.parseInt(sc.nextLine());
        Product product =  productController.getProductByIdController(id);
        //Step4
        System.out.println("---Product---");
        System.out.println("ID\tName\tDesc\tPrice");
        System.out.println(product.getId() + "\t" + product.getProName() + "\t"
                + product.getProDesc() +"\t" + product.getPrice());
    }

    public void getProductByName() throws SQLException, ClassNotFoundException{
        //step1:
        System.out.println("Enter name:");
        String name = sc.nextLine();
        ArrayList<Product> products = productController.getProductByNameController(name);
        System.out.println("---Products---");
        System.out.println("ID\tName\tDesc\tPrice");
        //Step 4
        for (Product product : products) {
            System.out.println(product.getId() + "\t" + product.getProName() + "\t"
                    + product.getProDesc() +"\t" + product.getPrice());
        }
    }

    public void getAllProduct()throws SQLException,ClassNotFoundException{
        //Step 1
        ArrayList<Product> products = productController.getAllProductController();
        System.out.println("---All products---");
        System.out.println("ID\tName\tDesc\tPrice");
        //Step 4
        for (Product product : products) {
            System.out.println(product.getId() + "\t" + product.getProName() + "\t"
                    + product.getProDesc() +"\t" + product.getPrice());
        }
    }

    public void updateProduct()throws SQLException, ClassNotFoundException{
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product description:");
        String DESC = sc.nextLine();
        System.out.println("Enter price of product:");
        Double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter id:");
        int id = Integer.parseInt(sc.nextLine());
        Product product = new Product(name,DESC,price);
        productController.updateProductController(product);
        System.out.println("---Product---");
        System.out.println("ID\tName\tDesc\tPrice");
        System.out.println(product.getId() + "\t" + product.getProName() + "\t"
                + product.getProDesc() +"\t" + product.getPrice());
    }

    public void deleteProduct()throws SQLException, ClassNotFoundException{
        System.out.println("Enter id of product ");
        int id = Integer.parseInt(sc.nextLine());
        //step4
        boolean result = productController.deleteProdutController(id);
        if(result){
            System.out.println("Product was removed");
        }else {
            System.out.println("Product not found!");
        }
    }

    public void ExportToJsonFile() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Product> products = productController.getAllProductController();
        String fileName = "productSQL.json";
        Path path = Paths.get(fileName);
        Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement tree = gson.toJsonTree(products);
        gson.toJson(tree, writer);
        writer.close();
        System.out.println("The file was successfully written");
    }

    public void ReadFileJSon() throws SQLException, ClassNotFoundException {
        ArrayList<Product> products;
        try {
            FileReader reader = new FileReader("productSQL.json");
            Type objectType = new TypeToken<ArrayList<Product>>(){}.getType();
            products = new Gson().fromJson(reader, objectType);
            for (Product product :products) {
                System.out.println(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

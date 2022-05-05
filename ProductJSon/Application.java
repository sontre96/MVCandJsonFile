package ProductJSon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ProductController productController = new ProductController();
        //doc file json
        productRepository.readFileJson();

        Scanner scanner = new Scanner(System.in);
//        Product product = new Product();
        List<Product> productList = productRepository.productList;
        int choose;
        do {
            Menu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("==== Product.Json ====");
                    productRepository.readFileJson();
                    List<Product> list = productRepository.productList;
                    break;
                case 2:
                    System.out.println("Enter product id:");
                    int id = Integer.parseInt(scanner.nextLine());
                    productController.getProductById(productList, id);
                    break;
                case 3:
                    System.out.println("enter product name: ");
                    String name = scanner.nextLine();
                    productController.getProductByName(productList, name);
                    break;
                case 4:
                    System.out.println("==== All Product ====");
                    productController.getAllProduct(productList);
                    break;
                case 5:
                    System.out.println("Exit !!!!");
                    break;
                default:
                    System.out.println("Fail !!! Please choose again!");
                    break;
            }
        } while (choose != 5);
    }

    public static void Menu() {
        System.out.println("===========================");
        System.out.println("1. Read file product.json");
        System.out.println("2. Search product by id");
        System.out.println("3. Search product by name");
        System.out.println("4. Get all product");
        System.out.println("5. Exit!!!!");
        System.out.println("Choose: ");
    }
}


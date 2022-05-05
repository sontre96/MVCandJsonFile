package ProductJSon;

import java.util.List;

public class ProductController {

    ProductRepository productRepository = new ProductRepository();

    public void getProductById(List<Product> list, int id){
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                System.out.println(list.get(i));
            }
        }
    }
    public void getProductByName (List<Product> list, String name){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getProName().contains(name)){
                System.out.println(list.get(i));
            }
        }
    }

    public void getAllProduct(List<Product> list){
        for (Product product : list) {
            System.out.println(product);
        }
    }
}

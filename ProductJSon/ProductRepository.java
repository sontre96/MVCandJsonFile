package ProductJSon;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ProductRepository {

    public List<Product> productList;

    public void readFileJson(){
        try {
            FileReader reader = new FileReader("Product.json");
            Type objectType = new TypeToken<List<Product>>(){}.getType();
            productList = new Gson().fromJson(reader, objectType);
            for (Product product: productList){
                System.out.println(product);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

}

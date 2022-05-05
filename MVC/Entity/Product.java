package jdbcapp.MVC.Entity;

public class Product {
    private int id;
    private String proName;
    private String proDesc;
    private Double price;

    public Product() {
    }

    public Product(String proName, String proDesc, Double price) {
        this.proName = proName;
        this.proDesc = proDesc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

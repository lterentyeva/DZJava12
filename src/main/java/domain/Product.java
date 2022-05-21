package domain;

public class Product {
    protected int id;
    protected String title;
    protected int price;

    public Product() {

    }

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

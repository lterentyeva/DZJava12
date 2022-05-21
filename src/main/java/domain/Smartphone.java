package domain;

public class Smartphone extends Product {
    protected String maker;

    public Smartphone() {

    }

    public Smartphone(int id, String title, int price, String maker) {
        super(id, title, price);
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}

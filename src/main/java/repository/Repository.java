package repository;

import domain.Product;

public class Repository {

    private Product[] products = new Product[0];


    public void save(Product product) {
        int length = products.length + 1;

        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] findById(int id) {
        Product[] tmp = new Product[products.length];
        for (int i = 0; i < products.length + 1; i++) {
            if (i == id) {
                return products;
            }
        }
        return null;
    }

    public String removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found.");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int i = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[i] = product;
                i++;
            }
            products = tmp;
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }
}

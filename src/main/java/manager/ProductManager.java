package manager;

import domain.Product;
import repository.Repository;

public class ProductManager {
    protected Product[] products = new Product[0];
    protected Repository repository = new Repository();


    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public void add(Product product) {
        repository.save(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}
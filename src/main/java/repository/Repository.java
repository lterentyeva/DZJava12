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

        public void removeById(int id) {
            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int i = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[i] = product;
                    i++;
                }
            }
            products = tmp;
        }

        public Product[] findAll() {
            return products;
        }
}

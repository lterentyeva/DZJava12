package man;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product first = new Book(1, "War and peace", 560, "Tolstoy");
    Product second = new Smartphone(2, "Samsung Note 10", 70000, "Samsung");
    Product third = new Book(3, "Demons", 650, "Dostoevsky");
    Product fourth = new Smartphone(4, "Samsung Note 20", 100000, "Samsung");



    @Test
    void shouldAddProduct() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        manager.add(first);
        manager.add(second);


        Product[] expected = {first, second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);


    }


    @Test
    void shouldSearchByText() {
        ProductManager manager = new ProductManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);


        Product[] expected = {third};
        Product[] actual = manager.searchBy("Demons");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextElse() {
        ProductManager manager = new ProductManager();


        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);


        Product[] expected = {second, fourth};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveById() {
        Repository repository = new Repository();

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(1);


        Product[] expected = {second, third, fourth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindMatches() {
        ProductManager manager = new ProductManager();

        String text = "War and peace";

        Boolean expected = true;
        Boolean actual = manager.matches(first, text);

        assertEquals(expected, actual);

    }
}

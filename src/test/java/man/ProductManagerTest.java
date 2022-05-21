package man;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product first = new Book(1, "Idiot", 560, "Dostoevsky");
    Product second = new Smartphone(3, "Samsung Note 9", 70000, "Samsung");
    Product third = new Book(2, "Demons", 650, "Dostoevsky");




    @Test
    void shouldAddProduct() {
        ProductManager manager = new ProductManager();

        manager.add(second);
        manager.add(third);

        Product[] expected = {second, third};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByText() {
        ProductManager manager = new ProductManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);


        Product[] expected = {second};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextElse() {
        ProductManager manager = new ProductManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);


        Product[] expected = {first, third};
        Product[] actual = manager.searchBy("Dostoevsky");

        assertArrayEquals(expected, actual);
    }



    @Test
    void shouldRemoveById() {
        Repository repository = new Repository();

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(1);


        Product[] expected = {second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindMatches() {
        ProductManager manager = new ProductManager();

        String text = "Idiot";

        Boolean expected = true;
        Boolean actual = manager.matches(first, text);

        assertEquals(expected, actual);

    }
}

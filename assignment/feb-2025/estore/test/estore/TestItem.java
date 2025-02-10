package estore;

import org.junit.jupiter.api.BeforeEach;

public class TestItem {

    Item item;
    int quantity;
    Product product;

    @BeforeEach
    public void setUp() {
        int id = 32;
        String name = "Test";
        double price = 12.0;
        String description = "Test";
        Category category = Category.CLOTHING;
        product = new Product(

        );
        item = new Item();
    }

}

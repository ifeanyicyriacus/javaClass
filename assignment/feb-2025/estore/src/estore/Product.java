package estore;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    public Product(int id, String name, double price, String description, Category category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}

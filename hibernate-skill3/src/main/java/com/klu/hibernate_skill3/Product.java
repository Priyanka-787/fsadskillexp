package com.klu.hibernate_skill3;



import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product() {}

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // getters & setters

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", desc=" + description +
                ", price=" + price + ", qty=" + quantity + "]";
    }
}

package entity;

import java.util.Objects;

public class Product {
    private String name;
    private int price;
    private String description;
    private String category;
    private boolean isAvailable;

    public Product(String name, int price, String description, String category, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + description + " " + category + " " + isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return price == product.price && isAvailable == product.isAvailable && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, category, isAvailable);
    }
}



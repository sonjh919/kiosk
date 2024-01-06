package kiosk.domain;

import java.util.Objects;

public class Product extends Menu{
    private final int price;

    public Product(String name, int price, String description) {
        super(name, description);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public int hashCode(){
        return Objects.hash(super.getName(), price, super.getDescription());
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) && price == product.price && Objects.equals(
                getDescription(), product.getDescription());
    }
}

package kiosk.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cart{
    private static final Cart cart = new Cart();
    private Cart(){}
    public static Cart getInstance(){
        return cart;
    }

    private Map<Product, Integer> products = new HashMap<>();

    public void add(Product product) {
        products.compute(product, (key, value) -> (value == null) ? 1 : value + 1);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int getTotalPrice(){
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : Cart.getInstance().getProducts().entrySet()) {
            sum += entry.getKey().getPrice()*entry.getValue();
        }
        return sum;
    }

    public void clear(){
        products.clear();
    }

    public Set<Product> getOrderProducts(){
        Set<Product> orderProducts = new HashSet<>();
        for (Map.Entry<Product, Integer> entry : Cart.getInstance().getProducts().entrySet()) {
            orderProducts.add(entry.getKey());
        }
        return orderProducts;
    }


}
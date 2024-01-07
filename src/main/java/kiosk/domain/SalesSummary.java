package kiosk.domain;

import java.util.HashSet;
import java.util.Set;

public class SalesSummary {
    private static final SalesSummary salesSummary = new SalesSummary();
    private SalesSummary(){}
    public static SalesSummary getInstance(){
        return salesSummary;
    }

    private int totalSalesAmount = 0;
    Set<Product> orderProducts = new HashSet<>();

    public int getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public Set<Product> getOrderProducts() {
        return orderProducts;
    }

    public void addAmount(int totalPrice){
        totalSalesAmount += totalPrice;
    }

    public void addProduct(Set<Product> orderProducts) {
        this.orderProducts.addAll(orderProducts);
    }
}

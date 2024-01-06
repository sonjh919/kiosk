package kiosk.service;

import kiosk.domain.Cart;
import kiosk.domain.Product;
import kiosk.domain.SalesSummary;
import kiosk.domain.WaitingNumber;
import kiosk.vo.ProductData;

public class KioskService {
    private Cart cart;
    private final SalesSummary salesSummary;
    private final WaitingNumber waitingNumber;

    public KioskService() {
        this.cart = Cart.getInstance();
        this.salesSummary = SalesSummary.getInstance();
        this.waitingNumber = WaitingNumber.getInstance();
    }

    public void addCart(ProductData productData) {
        Product product = new Product(productData.getName(), productData.getPrice(), productData.getDescription());
        cart.add(product);
    }

    public void order() {
        addSalesSummary();
        addWaitingNumber();
        clearCart();
    }

    private void addSalesSummary() {
        salesSummary.addAmount(cart.getTotalPrice());
        salesSummary.addProduct(cart.getOrderProducts());
    }

    private void addWaitingNumber() {
        waitingNumber.add();
    }

    public void clearCart() {
        cart.clear();
    }

    public void waitService(int wait) {
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

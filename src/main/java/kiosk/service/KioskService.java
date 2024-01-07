package kiosk.service;

import kiosk.domain.Cart;
import kiosk.domain.Product;
import kiosk.domain.SalesSummary;
import kiosk.domain.WaitTime;
import kiosk.domain.WaitingNumber;
import kiosk.vo.ProductData;

public class KioskService {
    private final Cart cart;
    private final SalesSummary salesSummary;
    private final WaitingNumber waitingNumber;

    private static final int WAIT_TIME= 3000;

    public KioskService() {
        this.cart = Cart.getInstance();
        this.salesSummary = SalesSummary.getInstance();
        this.waitingNumber = WaitingNumber.getInstance();
    }

    public void addCart(ProductData productData) {
        Product product = productData.createProduct();
        cart.add(product);
    }

    public WaitTime order() {
            IsCartEmpty();
            addSalesSummary();
            addWaitingNumber();
            clearCart();
        return new WaitTime(WAIT_TIME);
    }

    private void addSalesSummary() {
        salesSummary.addAmount(cart.getTotalPrice());
        salesSummary.addProduct(cart.getOrderProducts());
    }

    private void addWaitingNumber() {
        waitingNumber.add();
    }

    private void IsCartEmpty() {
        if (cart.IsEmpty()) {
            throw new RuntimeException();
        }
    }
    public void clearCart() { cart.clear(); }

    public void waitService(WaitTime waitTime) {
        try {
            Thread.sleep(waitTime.waitTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

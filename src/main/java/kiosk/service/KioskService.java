package kiosk.service;

import kiosk.domain.Cart;
import kiosk.domain.Product;
import kiosk.domain.SalesSummary;
import kiosk.vo.WaitTime;
import kiosk.domain.WaitingNumber;
import kiosk.vo.ProductData;

public class KioskService {
    private Cart cart;
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

    public void clearCart() {
        cart.clear();
    }

    public void waitService(WaitTime waitTime) {
        try {
            Thread.sleep(waitTime.waitTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

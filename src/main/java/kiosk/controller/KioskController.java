package kiosk.controller;

import kiosk.service.KioskService;
import kiosk.view.InputView;
import kiosk.view.OutputView;
import kiosk.vo.ProductData;

public class KioskController {
    private final KioskService kioskService;
    private final InputView inputView;
    private final OutputView outputView;

    public KioskController() {
        this.kioskService = new KioskService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        while (true) {
            selectMenu();
        }
    }

    private void selectMenu() {
        outputView.menu();
        int menuNumber = inputView.menu();

        switch (menuNumber) {
            case 1, 2, 3 -> selectProduct(menuNumber);
            case 4 -> orderProduct();
            case 5 -> cancelCart();
            case 0 -> printSalesSummary();
            case -1 -> System.exit(0);
        }
    }


    private void selectProduct(int menuNumber) {
        outputView.product(menuNumber);
        ProductData productData = inputView.product(menuNumber);

        if(isAddableToCart(productData)){
            kioskService.addCart(productData);
        }
    }

    private void orderProduct() {
        if(shouldOrder()){
            kioskService.order();
            int wait = 3000;
            outputView.orderComplete(wait);
            kioskService.waitService(wait);
        }
    }

    private void cancelCart() {
        if(shouldCancel()){
            kioskService.clearCart();
        }
    }

    private void printSalesSummary() {
        outputView.salesSummary();
        inputView.back();
    }

    private boolean shouldCancel() {
        outputView.cancelCartConfirmation();
        return inputView.cancel();
    }

    private boolean shouldOrder() {
        outputView.orderConfirmation();
        return inputView.order();
    }

    private boolean isAddableToCart(ProductData productData) {
        outputView.addToCartConfirmation(productData);
        return inputView.CartConfirm();
    }


}

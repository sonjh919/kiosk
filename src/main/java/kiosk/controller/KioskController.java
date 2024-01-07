package kiosk.controller;

import kiosk.vo.MenuNumber;
import kiosk.vo.WaitTime;
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
        MenuNumber menuNumber = inputView.menu();

        switch (menuNumber.getMenuNumber()) {
            case 1, 2, 3 -> selectProduct(menuNumber);
            case 4 -> orderProduct();
            case 5 -> cancelCart();
            case 0 -> printSalesSummary();
            case -1 -> System.exit(0);
        }
    }


    private void selectProduct(MenuNumber menuNumber) {
        outputView.product(menuNumber);
        ProductData productData = inputView.product(menuNumber);

        if(isAddableToCart(productData)){
            kioskService.addCart(productData);
        }
    }

    private void orderProduct() {
        if(shouldOrder()){
            WaitTime waitTime = kioskService.order();
            outputView.orderComplete(waitTime);
            kioskService.waitService(waitTime);
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

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

        switch (menuNumber.getMenuCategoryByMenuNumber()) {
            case COFFEE, DESSERT, DRINK-> selectProduct(menuNumber);
            case ORDER -> orderProduct();
            case CANCEL -> cancelCart();
            case SUMMARY -> printSalesSummary();
            case EXIT -> System.exit(0);
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
            try {
                WaitTime waitTime = kioskService.order();
                outputView.orderComplete(waitTime);
                kioskService.waitService(waitTime);
            }catch (RuntimeException e) {
                outputView.cartEmpty();
            }
        }
    }

    private void cancelCart() {
        if(shouldCancel()){
            kioskService.clearCart();
        }
    }

    private void printSalesSummary() {
        outputView.salesSummary();

        if(inputView.allowBack()){
            outputView.backToMenu();
        }
    }

    private boolean shouldCancel() {
        outputView.cancelCartConfirmation();
        return inputView.allowCancel();
    }

    private boolean shouldOrder() {
        outputView.orderConfirmation();
        return inputView.allowOrder();
    }

    private boolean isAddableToCart(ProductData productData) {
        outputView.addToCartConfirmation(productData);
        return inputView.allowAddCart();
    }

}

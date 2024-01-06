package kiosk;
import kiosk.controller.KioskController;

public class Application {
    public static void main(String[] args) {
        KioskController kioskController = new KioskController();
        kioskController.start();
    }
}
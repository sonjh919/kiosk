package kiosk.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import kiosk.vo.MenuCategory;
import kiosk.vo.ProductData;

public class InputView {
    private static final int INPUT_START_RANGE = -1;
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 형식입니다. 숫자만 입력해 주세요.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 범위에 맞는 숫자를 입력해 주세요.";
    private static final int CONFIRMATION = 1;
    private static final int BACK= 1;
    private static final int CANCEL = 2;

    public int menu() {
        while (true) {
            try {
                int menuNumber = readUserInput();
                validateMenuRange(menuNumber);
                return menuNumber;
            }catch(NumberFormatException e){
                System.out.println(INPUT_ERROR_MESSAGE);
            }
            catch (IllegalArgumentException e){
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public ProductData product(int menuNumber) {
        while (true) {
            try {
                int productNumber = readUserInput();
                return validateProductRange(menuNumber, productNumber);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e){
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public boolean CartConfirm() {
        while (true) {
            try {
                int cartConfirmation = readUserInput();
                return validateConfirmation(cartConfirmation);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e){
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public boolean order() {
        while (true) {
            try {
                int orderConfirmation = readUserInput();
                return validateConfirmation(orderConfirmation);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e){
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public boolean cancel() {
        while (true) {
            try {
                int cancelConfirmation = readUserInput();
                return validateConfirmation(cancelConfirmation);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e){
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }

    }

    public int back() {
        while (true) {
            try {
                int backConfirmation = readUserInput();
                validateBackConfirmation(backConfirmation);
                return backConfirmation;
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e){
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateBackConfirmation(int backConfirmation) {
        if(backConfirmation != BACK){
            throw new IllegalArgumentException();
        }
    }

    private boolean validateConfirmation(int confirmation) {
        if(confirmation == CONFIRMATION){ return true; }
        else if(confirmation == CANCEL){ return false; }
        throw new IllegalArgumentException();
    }

    private void validateMenuRange (int number){
        if(!(INPUT_START_RANGE <= number && number <= MenuCategory.countCategory())){
            throw new IllegalArgumentException();
        }
    }

    private ProductData validateProductRange (int menuNumber, int productNumber){
        return ProductData.getProductByOrdinal(menuNumber, productNumber);
    }

    private int readUserInput() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}

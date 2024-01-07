package kiosk.view;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntSupplier;
import kiosk.vo.MenuNumber;
import kiosk.vo.ProductData;

public class InputView {
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 형식입니다. 숫자만 입력해 주세요.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 범위에 맞는 숫자를 입력해 주세요.";
    private static final int CONFIRMATION = 1;
    private static final int BACK= 1;
    private static final int CANCEL = 2;


    public MenuNumber menu() {
        return getInputWithValidation(this::readUserInput, MenuNumber::new);
    }

    public ProductData product(MenuNumber menuNumber) {
        return getInputWithValidation(this::readUserInput, input -> validateProductRange(menuNumber, input));
    }

    public boolean allowAddCart() {
        return getInputWithValidation(this::readUserInput, this::validateConfirmation);
    }

    public boolean allowOrder() {
        return getInputWithValidation(this::readUserInput, this::validateConfirmation);
    }

    public boolean allowCancel() {
        return getInputWithValidation(this::readUserInput, this::validateConfirmation);
    }

    public boolean allowBack() {
        return getInputWithValidation(this::readUserInput, this::validateBackConfirmation);
    }

    private <T>T getInputWithValidation(IntSupplier inputSupplier, Function<Integer, T> function) {
        while (true) {
            try {
                int input = inputSupplier.getAsInt();
                return function.apply(input);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                System.out.println(RANGE_ERROR_MESSAGE);
            }
        }
    }

    private boolean validateBackConfirmation(int backConfirmation) {
        if(backConfirmation == BACK) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean validateConfirmation(int confirmation) {
        if(confirmation == CONFIRMATION){ return true; }
        else if(confirmation == CANCEL){ return false; }
        throw new IllegalArgumentException();
    }

    private ProductData validateProductRange (MenuNumber menuNumber, int productNumber){
        return ProductData.getProductByOrdinal(menuNumber, productNumber);
    }


    private int readUserInput() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}

package kiosk.view;

import java.util.Map;
import kiosk.domain.Cart;
import kiosk.domain.Product;
import kiosk.domain.SalesSummary;
import kiosk.domain.MenuNumber;
import kiosk.domain.WaitTime;
import kiosk.domain.WaitingNumber;
import kiosk.vo.MenuCategory;
import kiosk.vo.ProductData;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();
    private static final String SEPARATE_LINE = NEWLINE + "=========================================" + NEWLINE;

    private static final String START_MESSAGE = "\"JH CAFE에 오신걸 환영합니다.\"" + NEWLINE;
    private static final String MENU_MESSAGE = "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." + NEWLINE;
    private static final String MENU_TITLE = "[ JH CAFE 메뉴 ]";
    private static final String MENU_FORMAT = "%d. %s   | %s" + NEWLINE;
    private static final String PRODUCT_FORMAT = "%d. %s   | W %,d | %s";

    private static final String CART_FORMAT = "\"%s   | W %,d | %s\"";
    private static final String ADD_CART_FORMAT = "위 메뉴를 장바구니에 추가하시겠습니까?" + NEWLINE + "1. 확인        2. 취소  ";

    private static final String CART_EMPTY_MESSAGE = "[ERROR] 장바구니가 비어있습니다. 메뉴를 담은 후 주문을 진행해주세요.";
    private static final String ORDER_TITLE = "아래와 같이 주문 하시겠습니까?" + NEWLINE + NEWLINE + "[ Orders ]";
    private static final String ORDER_FORMAT = "%s   | W %,d | %d개 | %s";
    private static final String TOTAL_FORMAT = "[ TOTAL ]" + NEWLINE + "W %,d" + NEWLINE;
    private static final String ORDER_CONFIRM_FORMAT = "1. 주문        2. 메뉴판";
    private static final String ORDER_COMPLETE_FORMAT = "주문이 완료되었습니다!" + NEWLINE + NEWLINE + "대기번호는 [ %d ] 번 입니다."
            + NEWLINE + "(%d초후 메뉴판으로 돌아갑니다.)";

    private static final String CANCEL_CONFIRM_FORMAT = "진행하던 주문을 취소하시겠습니까?" + NEWLINE + "1. 확인     2. 취소";
    private static final String CANCEL_FORMAT = "진행하던 주문이 취소되었습니다.";

    private static final String TOTAL_SALES_AMOUNT_FORMAT = "[ 총 판매금액 현황 ]현재까지 총 판매된 금액은 [ W %,d ] 입니다." + NEWLINE;
    private static final String ORDER_PRODUCTS_TITLE = "[ 총 판매상품 목록 현황 ] 현재까지 총 판매된 상품 목록은 아래와 같습니다.";
    private static final String ORDER_PRODUCTS_FORMAT = "- %s   | W %,d";
    private static final String BACK = "1. 돌아가기";
    private static final String BACK_MESSAGE = "메뉴판으로 이동합니다.";

    private static final int INDEX = 1;
    private static final int MILLISECOND = 1000;

    public void menu() {
        System.out.println(SEPARATE_LINE + START_MESSAGE + MENU_MESSAGE + NEWLINE + MENU_TITLE);

        for(MenuCategory menuCategory : MenuCategory.values()){
            if(menuCategory == MenuCategory.SUMMARY || menuCategory == MenuCategory.EXIT) { continue; }
            System.out.printf(MENU_FORMAT, menuCategory.ordinal(), menuCategory.getMenu(),menuCategory.getDescription());
        }
    }

    public void product(MenuNumber menuNumber) {
        System.out.println(SEPARATE_LINE + MENU_MESSAGE);
        int productNumber = INDEX;
        for(ProductData product : ProductData.values()){
            if(product.getMenuCategory().ordinal() == menuNumber.getMenuNumber()){
                System.out.printf(PRODUCT_FORMAT + NEWLINE, productNumber, product.getName(), product.getPrice(), product.getDescription());
                productNumber++;
            }
        }
    }

    public void addToCartConfirmation(ProductData productData) {
        System.out.printf(SEPARATE_LINE + CART_FORMAT + NEWLINE, productData.getName(), productData.getPrice(), productData.getDescription());
        System.out.println(ADD_CART_FORMAT);
    }

    public void cartEmpty() {
        System.out.println(CART_EMPTY_MESSAGE);
    }

    public void orderConfirmation() {
        System.out.println(SEPARATE_LINE + ORDER_TITLE);

        for (Map.Entry<Product, Integer> entry : Cart.getInstance().getProducts().entrySet()) {
            System.out.printf(ORDER_FORMAT + NEWLINE, entry.getKey().getName(), entry.getKey().getPrice(), entry.getValue(), entry.getKey().getDescription());
        }

        System.out.printf(NEWLINE + TOTAL_FORMAT + NEWLINE + ORDER_CONFIRM_FORMAT + NEWLINE, Cart.getInstance().getTotalPrice());
    }

    public void orderComplete(WaitTime waitTime) {
        System.out.printf(SEPARATE_LINE + ORDER_COMPLETE_FORMAT + NEWLINE, WaitingNumber.getInstance().getWaitingNumber(), waitTime.waitTime()/MILLISECOND);
    }

    public void cancelCartConfirmation() {
        System.out.println(CANCEL_CONFIRM_FORMAT);
    }

    public void cancel() { System.out.println(NEWLINE + CANCEL_FORMAT); }

    public void salesSummary() {
        System.out.printf(TOTAL_SALES_AMOUNT_FORMAT+NEWLINE, SalesSummary.getInstance().getTotalSalesAmount());
        System.out.println(ORDER_PRODUCTS_TITLE);
        SalesSummary.getInstance().getOrderProducts().forEach(product ->
                System.out.printf(ORDER_PRODUCTS_FORMAT + NEWLINE, product.getName(), product.getPrice()));
        System.out.println(BACK);
    }

    public void backToMenu() {
        System.out.println(BACK_MESSAGE);
    }


}

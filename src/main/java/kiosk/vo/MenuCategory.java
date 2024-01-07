package kiosk.vo;

import kiosk.domain.Menu;

public enum MenuCategory {
    SUMMARY("총 주문 내역", "총 주문 금액과 상품 목록 출력"),
    COFFEE("커피", "커피냠냠"),
    DESSERT("디저트","디저트냠냠"),
    DRINK("마실거", "마실거냠냠"),
    ORDER("주문", "장바구니 확인 후 주문!"),
    CANCEL("취소", "진행중인 주문 취소!"),
    EXIT("키오스크 종료", "키오스크 종료");

    private final String name;
    private final String description;


    MenuCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static int countCategory() {
        return MenuCategory.values().length;
    }

    public static MenuCategory getMenuCategoryOrdinal(int menuNumber) {
        for (MenuCategory menuCategory : MenuCategory.values()){
            if(menuCategory.ordinal() == menuNumber){ return menuCategory;}
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public String getMenu() {
        return name;
    }

}

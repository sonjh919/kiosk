package kiosk.vo;

public enum MenuCategory {
    COFFEE("커피", "커피냠냠"),
    DESSERT("디저트","디저트냠냠"),
    DRINK("마실거", "마실거냠냠"),
    ORDER("주문", "장바구니 확인 후 주문!"),
    CANCEL("취소", "진행중인 주문 취소!");

    private final String name;
    private final String description;


    MenuCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static int countCategory() {
        return MenuCategory.values().length;
    }

    public String getDescription() {
        return description;
    }

    public String getMenu() {
        return name;
    }

}

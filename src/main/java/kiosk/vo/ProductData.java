package kiosk.vo;

public enum ProductData {
    AMERICANO("아메리카노", 3500, "아메리카노 냠냠", MenuCategory.COFFEE),
    ESPRESSO("에스프레소", 3000, "에스프레소 냠냠", MenuCategory.COFFEE),
    CAFELATTE("카페라떼", 4500, "카페라떼 냠냠", MenuCategory.COFFEE),
    CAKE("케이크", 8000, "케이크 냠냠", MenuCategory.DESSERT),
    PIE("파이", 5000, "파이 냠냠", MenuCategory.DESSERT),
    SANDWICH("샌드위치", 6000, "샌드위치 냠냠", MenuCategory.DESSERT),
    MACAROON("마카롱", 3500, "마카롱 냠냠", MenuCategory.DESSERT),
    ADE("에이드", 3500, "에이드 냠냠", MenuCategory.DRINK),
    SPRITE("스프라이트", 3000, "스프라이트 냠냠", MenuCategory.DRINK),
    COLA("콜라", 3000, "콜라 냠냠", MenuCategory.DRINK);

    private final String name;
    private final int price;
    private final String description;
    private final MenuCategory menuCategory;

    ProductData(String name, int price, String description, MenuCategory menuCategory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.menuCategory = menuCategory;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public MenuCategory getMenuCategory() { return menuCategory; }

    public static ProductData getProductByOrdinal(int categoryOrdinal, int productOrdinal) {
        int count = 1;
        for (ProductData product : ProductData.values()) {
            if (product.getMenuCategory().ordinal()+1 == categoryOrdinal){
                if(count==productOrdinal) {
                    return product;
                }
                count++;
            }
        }
      throw new IllegalArgumentException();
    }

}

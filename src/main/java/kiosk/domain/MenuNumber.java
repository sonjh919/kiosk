package kiosk.domain;

import kiosk.vo.MenuCategory;

public class MenuNumber{
    private int menuNumber;

    private static final MenuNumber INSTANCE = new MenuNumber();
    private MenuNumber() {}
    public static MenuNumber getInstance(int inputNumber){
        INSTANCE.menuNumber = inputNumber;
        return INSTANCE;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public boolean isCorrectOrdinal(int categoryOrdinal) {
        return INSTANCE.menuNumber == categoryOrdinal;
    }

    public MenuCategory getMenuCategoryByMenuNumber() {
        return MenuCategory.getMenuCategoryOrdinal(INSTANCE.menuNumber);
    }
}


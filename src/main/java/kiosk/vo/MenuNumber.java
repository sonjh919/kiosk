package kiosk.vo;

public class MenuNumber {
    private static final int INPUT_START_RANGE = 0;
    private final int menuNumber;


    public MenuNumber(int menuNumber) {
        validateMenuRange(menuNumber);
        this.menuNumber = menuNumber;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    private void validateMenuRange (int menuNumber){
        if(!(INPUT_START_RANGE <= menuNumber && menuNumber <= MenuCategory.countCategory())){
            throw new IllegalArgumentException();
        }
    }

    public boolean isCorrectOrdinal(int categoryOrdinal) {
        return menuNumber == categoryOrdinal;
    }

    public MenuCategory getMenuCategoryByMenuNumber(){
        return MenuCategory.getMenuCategoryOrdinal(menuNumber);
    }
}


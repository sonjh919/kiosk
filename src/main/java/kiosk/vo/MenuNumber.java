package kiosk.vo;

public record MenuNumber(int menuNumber) {
    private static final int INPUT_START_RANGE = 0;

    public MenuNumber {
        validateMenuRange(menuNumber);
    }

    private void validateMenuRange(int menuNumber) {
        if (!(INPUT_START_RANGE <= menuNumber && menuNumber <= MenuCategory.countCategory())) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isCorrectOrdinal(int categoryOrdinal) {
        return menuNumber == categoryOrdinal;
    }

    public MenuCategory getMenuCategoryByMenuNumber() {
        return MenuCategory.getMenuCategoryOrdinal(menuNumber);
    }
}


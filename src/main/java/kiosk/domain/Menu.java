package kiosk.domain;

public abstract class Menu {
    private final String name;
    private final String description;

    protected Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

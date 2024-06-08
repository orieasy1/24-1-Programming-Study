package project4.menu;

public enum MainMenuEnum {
    REGISTER_ASSET(1, "Register Asset"),
    SEARCH_ASSETS(2, "Search Assets"),
    EDIT_ASSETS(3, "Edit Assets"),
    EXIT(9, "Exit");

    private final int num;
    private final String name;

    MainMenuEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}

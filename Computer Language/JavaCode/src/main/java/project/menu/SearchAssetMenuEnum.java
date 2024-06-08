package project4.menu;

public enum SearchAssetMenuEnum {
    //Definition of the SearchAsseMenuEnum enum
    FULL_SEARCH(1, "Full Search"),
    BY_HARDWARE(2, "By Hardware"),
    BY_SOFTWARE(3, "By Software"),
    BACK_TO_MAIN_MENU(4, "Back to Main Menu");

    private final int num;
    private final String name;

    //Constructor
    SearchAssetMenuEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    //Method to get the menu item number and name
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

}

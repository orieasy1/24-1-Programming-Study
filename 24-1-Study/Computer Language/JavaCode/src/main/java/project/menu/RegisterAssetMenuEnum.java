package project.menu;

public enum RegisterAssetMenuEnum {
    //Definition of the RegisterAsseMenuEnum enum
    HARDWARE(1, "Hardware"),
    SOFTWARE(2, "Software"),
    BACK_TO_MAIN_MENU(3, "Back to Main Menu");

    private final int num;
    private final String name;

    //Constructor
    RegisterAssetMenuEnum(int num, String name) {
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

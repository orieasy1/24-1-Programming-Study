package project.menu;

public enum UpdateAssetMenuEnum {
    EDIT_BY_ID(1, "Edit by asset information (ID)"),
    BACK_TO_MAIN_MENU(2, "Back to Main Menu");

    private final int num;
    private final String name;

    UpdateAssetMenuEnum(int num, String name) {
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


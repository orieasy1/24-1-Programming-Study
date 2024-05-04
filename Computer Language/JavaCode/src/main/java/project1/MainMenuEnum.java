package project1;

public enum MainMenuEnum {
    //Definition of the MainMenuEnum enum
    REGISTER_ASSET(1, "Register Asset") ,
    SEARCH_ASSET(2, "Search Assets"),
    EXIT(9, "Exit");

    private final int num;
    private final String name;

    //Consturctor
    MainMenuEnum(int num, String name) {
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

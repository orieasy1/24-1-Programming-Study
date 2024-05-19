package project2;

public enum DepartmentEnum {
    IT(1, "IT"),
    HR(2, "HR"),
    Finance(3, "Finance"),
    Marketing(4, "Marketing");

    private final int num;
    private final String name;

  DepartmentEnum(int num, String name) {
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

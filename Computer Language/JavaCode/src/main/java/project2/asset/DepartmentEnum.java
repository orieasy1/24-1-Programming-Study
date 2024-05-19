package project2.asset;

public enum DepartmentEnum {
    IT(1, "IT"),
    HR(2, "HR"),
    FiNANCE(3, "Finance"),
    MARKETING(4, "Marketing");

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

    public static DepartmentEnum fromNum(int num) {
        for (DepartmentEnum department : values()) {
            if (department.getNum() == num) {
                return department;
            }
        }
        throw new IllegalArgumentException("Invalid department number: " + num);
    }


}

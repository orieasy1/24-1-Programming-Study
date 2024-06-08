package project4;

public enum DepartmentEnum {
    IT(1, "IT"),
    HR(2, "HR"),
    FINANCE(3, "Finance"),
    MARKETING(4, "Marketing");

    private final int num;
    private final String name;

    DepartmentEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public static DepartmentEnum fromNum(int num) {
        for (DepartmentEnum department : DepartmentEnum.values()) {
            if (department.getNum() == num) {
                return department;
            }
        }
        throw new IllegalArgumentException("Invaild department code.");
    }
}

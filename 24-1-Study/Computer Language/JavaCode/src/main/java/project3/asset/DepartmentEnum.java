package project3.asset;

public enum DepartmentEnum {
    IT(1, "IT"),
    HR(2, "HR"),
    FINANCE(3, "Finance"),
    MARKETING(4, "Marketing");

    // Enum fields to store the department number and name
    private final int num;
    private final String name;

    // Constructor to initialize the department enum
    DepartmentEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    // Getter method to retrieve the department number
    public int getNum() {
        return num;
    }

    // Getter method to retrieve the department name
    public String getName() {
        return name;
    }

    // Method to get the DepartmentEnum instance based on the department number
    public static DepartmentEnum fromNum(int num) {
        // Iterate through all enum values to find the matching department
        for (DepartmentEnum department : DepartmentEnum.values()) {
            if (department.getNum() == num) {
                return department;
            }
        }
        // Throw an exception if the department number is invalid
        throw new IllegalArgumentException("Invalid department code. ");
    }
}

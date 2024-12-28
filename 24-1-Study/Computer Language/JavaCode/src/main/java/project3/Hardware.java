package project3;

import project3.asset.DepartmentEnum;

public class Hardware {
    // Fields to store hardware details
    private int id;
    private String name;
    private DepartmentEnum department;
    private HardwareCategoryEnum category;
    private float price;

    // Constructor to initialize hardware with id, name, department, category, and price
    public Hardware(int id, String name, DepartmentEnum department,
                    HardwareCategoryEnum category, float price) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.category = category;
        this.price = price;
    }

    // Override the toString method to provide a string representation of the hardware details
    @Override
    public String toString() {
        return String.format(
                "ID: %d%nName: %s%nDepartment: %s (%d)%nCategory: %s (%d)%nPrice: $%.2f",
                id, name, department.getName(), department.getNum(), category.getName(), category.getNum(), price
        );
    }
}

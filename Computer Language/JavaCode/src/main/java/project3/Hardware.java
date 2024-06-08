package project2;

import project2.asset.DepartmentEnum;

public class Hardware {
    private int id;
    private String name;
    private DepartmentEnum department;
    private HardwareCategoryEnum category;
    private float price;

    public Hardware(int id, String name, DepartmentEnum department,
                    HardwareCategoryEnum category, float price) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.category =category;
        this.price =price;
    }

    @Override
    public String toString() {
        return String.format(
                "%nHardware regitered succesfully!%nID: %d%nName: %s%nDepartment: %s (%d)%nCategory: %s (%d)%nPrice: %.2f",
                id, name, department.getName(), department.getNum(), category.getName(), category.getNum(), price
        );
    }

}


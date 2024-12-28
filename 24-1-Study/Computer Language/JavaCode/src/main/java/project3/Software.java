package project3;

import project3.asset.DepartmentEnum;

public class Software {
    // Fields to store software details
    private int id;
    private String name;
    private DepartmentEnum department;
    private float price;
    private String licenseKey;

    // Constructor to initialize software with id, name, department, price, and license key
    public Software(int id, String name, DepartmentEnum department,
                    float price, String licenseKey) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.price = price;
        this.licenseKey = licenseKey;
    }

    // Override the toString method to provide a string representation of the software details
    @Override
    public String toString() {
        return String.format(
                "ID: %d%nName: %s%nDepartment: %s (%d)%nPrice: $%.2f%nLicense Key: %s",
                id, name, department.getName(), department.getNum(), price, licenseKey
        );
    }
}

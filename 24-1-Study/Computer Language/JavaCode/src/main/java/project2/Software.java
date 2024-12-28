package project2;

import project2.asset.DepartmentEnum;

public class Software {
    private int id;
    private String name;
    private DepartmentEnum department;
    private float price;
    private String licenseKey;

    public Software(int id, String name, DepartmentEnum department,
                    float price, String licenseKey) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.price =price;
        this.licenseKey = licenseKey;
    }

    @Override
    public String toString() {
        return String.format(
                "%nSoftware registered succesfully!%nID: %d%nName: %s%nDepartment: %s (%d)%nPrice: %.2f%nLicense Key: %s",
                id, name, department.getName(), department.getNum(), price, licenseKey
        );
    }
}

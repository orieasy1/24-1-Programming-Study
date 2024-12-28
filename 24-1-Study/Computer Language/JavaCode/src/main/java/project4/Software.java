package project4;

import project.DepartmentEnum;

public class Software extends ITAsset {
    private String licenseKey;

    public Software(int id, String name, DepartmentEnum department, float price, String licenseKey) {
        super(id, name, department, price);
        this.licenseKey = licenseKey;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", License Key: %s", licenseKey);
    }
}

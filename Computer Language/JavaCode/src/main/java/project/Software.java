package project;


public class Software extends ITAsset {
    // Fields specific to software
    private String licenseKey;

    // Constructor to initialize software
    public Software(int id, String name, DepartmentEnum department,
                    float price, String licenseKey) {
        super(id, name, department, price);
        this.licenseKey = licenseKey;
    }

    // Getter for licenseKey
    public String getLicenseKey() {
        return licenseKey;
    }

    // Setter for licenseKey
    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    // Override print method to provide a string representation of the software details
    @Override
    public void print() {
        System.out.println(String.format(
                "ID: %d%nName: %s%nDepartment: %s (%d)%nPrice: $%.2f%nLicense Key: %s",
                getId(), getName(), getDepartment().getName(), getDepartment().getNum(),
                getPrice(), licenseKey
        ));
    }
}

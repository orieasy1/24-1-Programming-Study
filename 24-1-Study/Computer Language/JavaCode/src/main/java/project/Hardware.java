package project;


public class Hardware extends ITAsset {
    // Fields specific to hardware
    private HardwareCategoryEnum category;

    // Constructor to initialize hardware
    public Hardware(int id, String name, DepartmentEnum department,
                    HardwareCategoryEnum category, float price) {
        super(id, name, department, price);
        this.category = category;
    }

    // Getter for category
    public HardwareCategoryEnum getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(HardwareCategoryEnum category) {
        this.category = category;
    }

    // Override print method to provide a string representation of the hardware details
    @Override
    public void print() {
        System.out.println(String.format(
                "ID: %d%nName: %s%nDepartment: %s (%d)%nCategory: %s (%d)%nPrice: $%.2f",
                getId(), getName(), getDepartment().getName(), getDepartment().getNum(),
                category.getName(), category.getNum(), getPrice()
        ));
    }
}

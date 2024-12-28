package project;

public abstract class ITAsset {
    // Fields to store asset details
    private int id;
    private String name;
    private DepartmentEnum department;
    private float price;

    // Constructor to initialize an IT asset
    public ITAsset(int id, String name, DepartmentEnum department, float price) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.price = price;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for department
    public DepartmentEnum getDepartment() {
        return department;
    }

    // Setter for department
    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    // Getter for price
    public float getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(float price) {
        this.price = price;
    }

    // Abstract method for printing asset details
    public abstract void print();
}

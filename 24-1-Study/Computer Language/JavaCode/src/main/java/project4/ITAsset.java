package project4;

import project.DepartmentEnum;

public abstract class ITAsset {
    private int id;
    private String name;
    private DepartmentEnum department;
    private float price;

    public ITAsset(int id, String name, DepartmentEnum department, float price) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Department: %s, Price: %.2f",
                id, name, department.getName(), price);
    }

    public abstract void print();
}

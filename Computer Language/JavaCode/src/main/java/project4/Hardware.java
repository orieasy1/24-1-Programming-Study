package project4;

import project.DepartmentEnum;
import project.HardwareCategoryEnum;

public class Hardware extends ITAsset {
    private HardwareCategoryEnum category;

    public Hardware(int id, String name, DepartmentEnum department, HardwareCategoryEnum category, float price) {
        super(id, name, department, price);
        this.category = category;
    }

    public HardwareCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(HardwareCategoryEnum category) {
        this.category = category;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Category: %s", category.getName());
    }
}
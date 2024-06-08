package project2;

public enum HardwareCategoryEnum {
    Input(1, "Input"),
    PROCESSING(2, "Processing"),
    STORAGE(3, "Storage"),
    OUTPUT(4, "Output"),
    COMMUNICATION(5, "Communication");

    private final int num;
    private final String name;

    HardwareCategoryEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    //Method to get the menu item number and name
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public static HardwareCategoryEnum fromNum(int num) {
        for (HardwareCategoryEnum category : values()) {
            if (category.getNum() == num) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid category number: " + num);
    }
}

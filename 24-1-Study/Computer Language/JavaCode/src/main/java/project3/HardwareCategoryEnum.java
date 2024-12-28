package project3;

public enum HardwareCategoryEnum {
    // Definition of the HardwareCategoryEnum enum with hardware categories
    INPUT(1, "Input"),
    PROCESSING(2, "Processing"),
    STORAGE(3, "Storage"),
    OUTPUT(4, "Output"),
    COMMUNICATION(5, "Communication");

    // Enum fields to store the category number and name
    private final int num;
    private final String name;

    // Constructor to initialize the hardware category enum
    HardwareCategoryEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    // Method to get the category number
    public int getNum() {
        return num;
    }

    // Method to get the category name
    public String getName() {
        return name;
    }

    // Method to get the HardwareCategoryEnum instance based on the category number
    public static HardwareCategoryEnum fromNum(int num) {
        // Iterate through all enum values to find the matching category
        for (HardwareCategoryEnum category : HardwareCategoryEnum.values()) {
            if (category.getNum() == num) {
                return category;
            }
        }
        // Throw an exception if the category number is invalid
        throw new IllegalArgumentException("Invalid category code.");
    }
}

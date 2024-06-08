package project;

public enum HardwareCategoryEnum {
    INPUT(1, "Input"),
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

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public static HardwareCategoryEnum fromNum(int num) {
        for (HardwareCategoryEnum category : HardwareCategoryEnum.values()) {
            if (category.getNum() == num) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invaild category code. ");
    }
}

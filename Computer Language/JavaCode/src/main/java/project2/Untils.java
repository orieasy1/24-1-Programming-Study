package project2;

import project2.asset.AssetSet;
import project2.asset.DepartmentEnum;

import java.util.Scanner;

public class Untils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many hardware assets do you want to store?");
        int hardwareSize = scanner.nextInt();
        System.out.print("How many software assets do you want to store?");
        int softwareSize = scanner.nextInt();
        System.out.println();

        AssetSet assetSet = new AssetSet(hardwareSize, softwareSize);

        for (int i = 0; i < hardwareSize; i++) {
            System.out.println("Registering Hardware Asset " + (i + 1) + " of " + hardwareSize);
            assetSet.addHardware(registerHardwareAsset());
            System.out.println();
        }

        for (int i = 0; i < softwareSize; i++) {
            System.out.println("Registering Software Asset " + (i + 1) + " of " + softwareSize);
            assetSet.addSoftware(registerSoftwareAsset());
            System.out.println();
        }
    }

    private static Hardware registerHardwareAsset() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---Register New Hardware---");
        System.out.print("Enter Hardware ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Hardware name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department [");
        for(DepartmentEnum department : DepartmentEnum.values()) {
            System.out.print(department.getNum() + ": " + department.getName() + "  ");
        }
        System.out.print("]: ");
        int departmentNum = scanner.nextInt();
        DepartmentEnum department = DepartmentEnum.fromNum(departmentNum);

        System.out.print("Enter Hardware Category [");
        for(HardwareCategoryEnum category : HardwareCategoryEnum.values()) {
            System.out.print(" " +category.getNum() + ": " + category.getName());
        }
        System.out.print(" ]: ");
        int categoryNum = scanner.nextInt();
        HardwareCategoryEnum category = HardwareCategoryEnum.fromNum(categoryNum);

        System.out.print("Enter Price: ");
        float price = scanner.nextFloat();

        Hardware hardware = new Hardware(id, name, department, category, price);
        System.out.println(hardware.toString());
        return hardware;
    }

    private static Software registerSoftwareAsset() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---Register New Software---");
        System.out.print("Enter Software ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Software name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department [");
        for(DepartmentEnum department : DepartmentEnum.values()) {
            System.out.print(" "+ department.getNum() + ": " + department.getName());
        }
        System.out.print(" ]: ");
        int departmentNum = scanner.nextInt();
        DepartmentEnum department = DepartmentEnum.fromNum(departmentNum);

        System.out.print("Enter Price: ");
        float price = scanner.nextFloat();

        System.out.print("Enter Software License Key: ");
        String licenseKey = scanner.next();

        Software software = new Software(id, name, department, price, licenseKey);
        System.out.println(software.toString());
        return software;
    }
}

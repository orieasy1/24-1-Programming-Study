package project3;

import project3.asset.AssetSet;
import project3.asset.DepartmentEnum;
import project3.menu.MainMenuEnum;
import project3.menu.RegisterAssetMenuEnum;
import project3.menu.SearchAssetMenuEnum;

import java.util.Scanner;

public class ITAssetManagementSystem {
    private static AssetSet assetSet = new AssetSet();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 9) {
            displayMainMenu(); // Display the main menu
            choice = scanner.nextInt(); // Get user's choice

            switch (choice) {
                case 1:
                    registerAsset(); // If choice is 1, register a new asset
                    break;
                case 2:
                    searchAsset(); // If choice is 2, search for an asset
                    break;
                case 9:
                    System.out.println("Exiting..."); // If choice is 9, exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n"); // For invalid choices
                    break;
            }
        }
    }

    // Display the main menu options
    private static void displayMainMenu() {
        System.out.println("IT Asset Management System");
        for (MainMenuEnum system : MainMenuEnum.values()) {
            System.out.println(system.getNum() + ". " + system.getName());
        }
        System.out.print("Enter choice: ");
    }

    // Method to register a new asset
    private static void registerAsset() {
        System.out.println("\nRegister Asset");
        for (RegisterAssetMenuEnum asset : RegisterAssetMenuEnum.values()) {
            System.out.println(asset.getNum() + ". " + asset.getName());
        }
        System.out.print("Enter choice: ");
        int regChoice = scanner.nextInt();

        System.out.println();

        switch (regChoice) {
            case 1:
                assetSet.addHardware(registerHardwareAsset()); // Register hardware asset
                assetSet.printHardwareDetails(assetSet.getHardwares().size() - 1);
                System.out.println();
                break;
            case 2:
                assetSet.addSoftware(registerSoftwareAsset()); // Register software asset
                assetSet.printSoftwareDetails(assetSet.getSoftwares().size() - 1);
                System.out.println();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }

    // Method to register a new hardware asset
    private static Hardware registerHardwareAsset() {
        System.out.println("---Register New Hardware---");
        System.out.print("Enter Hardware ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Hardware name: ");
        String name = scanner.nextLine();

        // Display department options
        System.out.print("Enter Department [");
        for (DepartmentEnum department : DepartmentEnum.values()) {
            System.out.print(department.getNum() + ": " + department.getName());
            if (department != DepartmentEnum.values()[DepartmentEnum.values().length - 1]) {
                System.out.print(", ");
            }
        }
        System.out.print("]: ");

        DepartmentEnum department = null;
        while (department == null) {
            try {
                int departmentNum = scanner.nextInt();
                department = DepartmentEnum.fromNum(departmentNum);
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                System.out.print("Please try again: ");
            }
        }

        // Display hardware category options
        System.out.print("Enter Hardware Category [");
        for (HardwareCategoryEnum category : HardwareCategoryEnum.values()) {
            System.out.print(category.getNum() + ": " + category.getName());
            if (category != HardwareCategoryEnum.values()[HardwareCategoryEnum.values().length - 1]) {
                System.out.print(", ");
            }
        }
        System.out.print("]: ");

        HardwareCategoryEnum category = null;
        while (category == null) {
            try {
                int categoryNum = scanner.nextInt();
                category = HardwareCategoryEnum.fromNum(categoryNum);
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                System.out.print("Please try again: ");
            }
        }

        System.out.print("Enter Price: ");
        float price = scanner.nextFloat();

        return new Hardware(id, name, department, category, price);
    }

    // Method to register a new software asset
    private static Software registerSoftwareAsset() {
        System.out.println("---Register New Software---");
        System.out.print("Enter Software ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Software name: ");
        String name = scanner.nextLine();

        // Display department options
        System.out.print("Enter Department [");
        for (DepartmentEnum department : DepartmentEnum.values()) {
            System.out.print(department.getNum() + ": " + department.getName());
            if (department != DepartmentEnum.values()[DepartmentEnum.values().length - 1]) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]: ");

        DepartmentEnum department = null;
        while (department == null) {
            try {
                int departmentNum = scanner.nextInt();
                department = DepartmentEnum.fromNum(departmentNum);
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                System.out.print("Please try again. ");
            }
        }

        System.out.print("Enter Price: ");
        float price = scanner.nextFloat();

        System.out.print("Enter Software License Key: ");
        String licenseKey = scanner.next();

        return new Software(id, name, department, price, licenseKey);
    }

    // Method to search for an asset
    private static void searchAsset() {
        System.out.println("\nSearch Asset");
        for (SearchAssetMenuEnum asset : SearchAssetMenuEnum.values()) {
            System.out.println(asset.getNum() + ". " + asset.getName());
        }
        System.out.print("Enter choice: ");
        int seaChoice = scanner.nextInt();

        System.out.println();

        switch (seaChoice) {
            case 1:
                System.out.println("--- Full Asset Search ---");
                System.out.println("Listing all registered assets...");
                System.out.println();
                assetSet.displayAllAssets(); // Display all registered assets
                break;
            case 2:
                System.out.println("--- Hardware Asset Search ---");
                System.out.println("Listing all registered hardware assets...");
                System.out.println();
                assetSet.displayHardwareAssets(); // Display registered hardware assets
                break;
            case 3:
                System.out.println("--- Software Asset Search ---");
                System.out.println("Listing all registered Software assets...");
                System.out.println();
                assetSet.displaySoftwareAssets(); // Display registered software assets
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
        System.out.println();
    }
}

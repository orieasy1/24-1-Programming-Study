/*
* package project4;


import project.DepartmentEnum;
import project.HardwareCategoryEnum;
import project.menu.MainMenuEnum;
import project.menu.RegisterAssetMenuEnum;
import project.menu.SearchAssetMenuEnum;
import project.menu.UpdateAssetMenuEnum;

import java.util.Scanner;

import static project3.ITAssetManagementSystem.scanner;


public class ITAssetManagementSystem {
    private static ITAssetSet itAssetSet = new ITAssetSet(); // 추가: 프로젝트 4의 ITAssetSet 인스턴스 생성
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 9) {
            displayMainMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerAsset();
                    break;
                case 2:
                    searchAsset();
                    break;
                case 3:
                    editAsset();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("IT Asset Management System");
        for (MainMenuEnum system : MainMenuEnum.values()) {
            System.out.println(system.getNum() + ". " + system.getName());
        }
        System.out.print("Enter choice: ");
    }

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
                // 추가: 프로젝트 3의 AssetSet에 하드웨어 추가
                assetSet.addHardware(registerHardwareAsset());
                // 추가: 프로젝트 4의 ITAssetSet에 하드웨어 추가
                itAssetSet.addAsset(registerHardwareAsset());
                // 수정: 프로젝트 4의 ITAssetSet의 printHardwareDetails 메서드 호출
                itAssetSet.printHardwareDetails(itAssetSet.getHardwares().get(itAssetSet.getHardwares().size() - 1));
                System.out.println();
                break;
            case 2:
                // 추가: 프로젝트 3의 AssetSet에 소프트웨어 추가
                assetSet.addSoftware(registerSoftwareAsset());
                // 추가: 프로젝트 4의 ITAssetSet에 소프트웨어 추가
                itAssetSet.addAsset(registerSoftwareAsset());
                // 수정: 프로젝트 4의 ITAssetSet의 printSoftwareDetails 메서드 호출
                itAssetSet.printSoftwareDetails(itAssetSet.getSoftwares().get(itAssetSet.getSoftwares().size() - 1));
                System.out.println();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }

    // 나머지 메서드들은 이전과 동일하게 유지됩니다.
}


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
                System.out.println("Invalid department code. Please try again: ");
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
                System.out.println("Invalid category code. Please try again: ");
            }
        }

        System.out.print("Enter Price: ");
        float price = scanner.nextFloat();

        return new Hardware(id, name, department, category, price);
    }

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
        System.out.print("]: ");

        DepartmentEnum department = null;
        while (department == null) {
            try {
                int departmentNum = scanner.nextInt();
                department = DepartmentEnum.fromNum(departmentNum);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid department code. Please try again: ");
            }
        }

        System.out.print("Enter Price: ");
        float price = scanner.nextFloat();

        System.out.print("Enter Software License Key: ");
        String licenseKey = scanner.next();

        return new Software(id, name, department, price, licenseKey);
    }

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
                assetSet.printAllAssets();
                break;
            case 2:
                System.out.println("--- Hardware Asset Search ---");
                System.out.println("Listing all registered hardware assets...");
                assetSet.printHardwareAssets();
                break;
            case 3:
                System.out.println("--- Software Asset Search ---");
                System.out.println("Listing all registered software assets...");
                assetSet.printSoftwareAssets();
                break;
            case 4:
                System.out.println("--- Search by Asset Name ---");
                System.out.print("Enter asset name to search: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                assetSet.searchAssetsByName(name);
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
        System.out.println();
    }

    private static void editAsset() {
        System.out.println("\nEdit Asset");
        for (UpdateAssetMenuEnum asset : UpdateAssetMenuEnum.values()) {
            System.out.println(asset.getNum() + ". " + asset.getName());
        }
        System.out.print("Enter choice");

        int editChoice = scanner.nextInt();

        switch (editChoice) {
            case 1:
                System.out.print("Enter asset ID to edit: ");
                int id = scanner.nextInt();
                ITAsset asset = assetSet.getAssetById(id);
                if (asset != null) {
                    System.out.println("Editing asset: " + asset);
                    System.out.print("Enter new name (leave blank to keep current): ");
                    scanner.nextLine(); // Consume newline
                    String newName = scanner.nextLine();
                    if (!newName.isBlank()) {
                        asset.setName(newName);
                    }

                    System.out.print("Enter new price (leave blank to keep current): ");
                    String newPriceStr = scanner.nextLine();
                    if (!newPriceStr.isBlank()) {
                        float newPrice = Float.parseFloat(newPriceStr);
                        asset.setPrice(newPrice);
                    }

                    if (asset instanceof Hardware) {
                        Hardware hardware = (Hardware) asset;
                        System.out.print("Enter new category [");
                        for (HardwareCategoryEnum category : HardwareCategoryEnum.values()) {
                            System.out.print(category.getNum() + ": " + category.getName());
                            if (category != HardwareCategoryEnum.values()[HardwareCategoryEnum.values().length - 1]) {
                                System.out.print(", ");
                            }
                        }
                        System.out.print("] (leave blank to keep current): ");
                        String newCategoryStr = scanner.nextLine();
                        if (!newCategoryStr.isBlank()) {
                            int newCategoryNum = Integer.parseInt(newCategoryStr);
                            HardwareCategoryEnum newCategory = HardwareCategoryEnum.fromNum(newCategoryNum);
                            hardware.setCategory(newCategory);
                        }
                    } else if (asset instanceof Software) {
                        Software software = (Software) asset;
                        System.out.print("Enter new license key (leave blank to keep current): ");
                        String newLicenseKey = scanner.nextLine();
                        if (!newLicenseKey.isBlank()) {
                            software.setLicenseKey(newLicenseKey);
                        }
                    }
                    System.out.println("Asset updated: " + asset);
                } else {
                    System.out.println("Asset not found.");
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }
}

* */
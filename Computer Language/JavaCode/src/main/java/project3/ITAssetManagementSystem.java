package project1;

import java.util.Scanner;

public class ITAssetManagementSystem {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        //until user types 9, the program continues
        while(choice != 9){
            displayMainMenu(); //display list of Main Menu
            choice = scanner.nextInt(); //get user's choice of Main Menu

            switch(choice) {
                case 1:
                    registerAsset();
                    break;
                case 2:
                    searchAsset();
                    break;
                case 9:
                    //if user choose 9 print "Exiting..." and end program
                    System.out.println("Exiting...");
                    break;
                default:
                    //if user types number except 1, 2, 9 print "Invalid choice. Please try again."
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }

    }

    private static void displayMainMenu() {
        //Display list of Main Menu
        System.out.println("IT Asset Management System");
        for(MainMenuEnum system : MainMenuEnum.values()) {
            System.out.println(system.getNum() + ". " + system.getName());
        }
        System.out.print("Enter choice: ");
    }

    private static void registerAsset() {
        Scanner scanner = new Scanner(System.in);

        //Display list of Register Asset Menu
        System.out.println("\nRegister Asset");
        for(RegisterAssetMenuEnum asset : RegisterAssetMenuEnum.values()) {
            System.out.println(asset.getNum() + ". " + asset.getName());
        }
        System.out.print("Enter choice: ");
        int regChoice = scanner.nextInt();  //get user's choice of Register Asset Menu

        //print result of user's choice
        switch(regChoice) {
            case 1:
                System.out.println("Hardware Registration is under development.");
                break;
            case 2:
                System.out.println("Software Registration is under development.");
                break;
            case 3:
                break;
        }
        System.out.println();
    }

    private static void searchAsset() {
        Scanner scanner = new Scanner(System.in);

        //Display list of Search Asset Menu
        System.out.println("\nSearch Asset");
        for(SearchAssetMenuEnum asset : SearchAssetMenuEnum.values()) {
            System.out.println(asset.getNum() + ". " + asset.getName());
        }
        System.out.print("Enter choice: ");
        int seaChoice = scanner.nextInt();  //get user's choice of Search Asset Menu

        //print result of user's choice
        switch(seaChoice) {
            case 1:
                System.out.println("Full asset search is under development.");
                break;
            case 2:
                System.out.println("Hardware asset search is under development.");
                break;
            case 3:
                System.out.println("Software asset search is under development.");
                break;
            case 4:
                break;
        }
        System.out.println();
    }

}

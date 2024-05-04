package project1;

import java.util.Scanner;

public class ITAssetManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice != 9) {
            System.out.println("IT Asset Management System");
            for(MainMenuEnum system : MainMenuEnum.values()) {
                System.out.println(system.getNum() + ". " + system.getName());
            }
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice == 1){
                System.out.println("\nRegister Asset");
                for(RegisterAssetMenuEnum system : RegisterAssetMenuEnum.values()) {
                    System.out.println(system.getNum() + ". " + system.getName());
                }
                System.out.print("Enter choice: ");
                int RegChoice = scanner.nextInt();

                switch(RegChoice) {
                    case 1:
                        System.out.println("Hardware Registration is under development.");
                        break;
                    case 2:
                        System.out.println("Software Registration is under development.");
                        break;
                    case 3: break;
                }
                System.out.println();

            }else if(choice == 2) {
                System.out.println("\nSearch Asset");
                for(SearchAssetMenuEnum system : SearchAssetMenuEnum.values()) {
                    System.out.println(system.getNum() + ". " + system.getName());
                }
                System.out.print("Enter choice: ");
                int SeaChoice = scanner.nextInt();

                switch(SeaChoice) {
                    case 1:
                        System.out.println("Full asset search is under development.");
                        break;
                    case 2:
                        System.out.println("Hardware asset search is under development.");
                        break;
                    case 3:
                        System.out.println("Software asset search is under development.");
                        break;
                    case 4: break;
                }
                System.out.println();

            }else if(choice == 9){
                System.out.println("Exiting...");

            }else {
                System.out.println("Invaild choice. Please try again.");
                System.out.println();
            }
        }
    }
}

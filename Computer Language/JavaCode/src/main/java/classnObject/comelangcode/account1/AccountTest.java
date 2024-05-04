package classnObject.comelangcode.account1;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account myaccount = new Account();

        System.out.printf("Initial name is: %s%n%n", myaccount.getName());
        String theName = scanner.nextLine();
        myaccount.setName(theName);
        System.out.println();

        System.out.printf("Name in object myAccount is: %n%s%n", myaccount.getName());
    }
}

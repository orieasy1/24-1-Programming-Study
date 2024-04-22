package classnInstance.comLangCode.account2;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("Jiwon");
        Account account2 = new Account("Leezie");

        System.out.printf("account1 name is: %s%n", account1.getName());
        System.out.printf("account2 name is: %s%n", account2.getName());
    }
}

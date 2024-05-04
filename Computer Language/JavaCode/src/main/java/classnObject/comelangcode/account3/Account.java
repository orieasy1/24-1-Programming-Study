package classnObject.comelangcode.account3;

public class Account {
    private String name; // instance variable
    private double balance; // instance variable

    // Account constructor that receives two parameters
    public Account(String name, double balance) {
        this.name = name; // assign name to instance variable name

        // validate that the balance is greater than 0.0; if it's not,
        // instance variable balance keeps its default initial value of 0.0
        if(balance >= 0){
            this.balance = balance;
        }
    }

    // method that deposits (adds) only a valid amount to the balance
    public void deposit(double depositAmount){
        if(depositAmount >= 0) {
            balance += depositAmount;
        }
    }

    // method returns the account balance
    public double getBalance() {
        return balance;
    }

    // method that sets the name
    public void setName(String name) {
        this.name = name;
    }/* Create a method "setName" that modifies the instance variable name of the account. Set the parameters accordingly */

    // method that returns the name
    public String getName(){
        return name;
    }/* Create a method "getName" that returns the instance variable "name" */
}
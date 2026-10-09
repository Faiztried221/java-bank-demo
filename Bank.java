public class Bank {
    private String ownerName;
    private int balance;

    public Bank(String ownerName, int balance){
        this.ownerName =ownerName;
        this.balance = balance;
    }

    public String getOwner(){
        return ownerName;
    }

    public void withdraw(int amount){
            this.balance -= amount;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public int getBalance(){
        return this.balance;
    }
}

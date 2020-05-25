package JavaCore.multithreading.ComputerScienceCenter.demo3;

public class Account {
    private long balance;

    public Account(){
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    //положить деньги на счет
    public synchronized void deposit(long amount){
        checkAmountNonNegative(amount);
        balance += amount;
       // System.out.println("положить деньги на счет");
    }

    //снять деньги со счета
    public synchronized void withdraw(long amount){
        checkAmountNonNegative(amount);
        if(balance < amount){
            throw new IllegalArgumentException("not enough money");
        }
        balance -= amount;
       // System.out.println(" снять деньги со счета");

    }

    private static void checkAmountNonNegative(long amount) {
        if(amount < 0){
            throw new IllegalArgumentException("not enough money");
        }
    }
}

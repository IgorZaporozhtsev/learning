package JavaCore.multithreading.synchronization.wait_notify.demo4;

//Класс счет (в банке)
public class Account4 {
    private long balance;

    public Account4(){
        this(0L);
    }

    public Account4(long balance) {
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
        notifyAll(); //рассылает уведомление всем потокам уведомление которые спят на том же самом мониторе (экземпляр класса Account4)
    }

    //снять деньги со счета
   public synchronized void withdraw(long amount){
        checkAmountNonNegative(amount);
        if(balance < amount){
            throw new IllegalArgumentException("not enough money");
        }
        balance -= amount;

    }

    public synchronized void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        while (balance < amount){ //достаточно ли на счету денег
            this.wait();
        }

        balance -= amount;
    }

    private static void checkAmountNonNegative(long amount) {
        if(amount < 0){
            throw new IllegalArgumentException("not enough money");
        }
    }
}

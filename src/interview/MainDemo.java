package interview;

import java.math.BigDecimal;

public class MainDemo {

    public static void main(String[] args) {
        Account account1 = new Account(1, BigDecimal.valueOf(100));
        Account account2 = new Account(3, BigDecimal.valueOf(100));

        System.out.println(foo(account1, account2, BigDecimal.valueOf(150)));
        System.out.println(account1.balance);
        System.out.println(account2.balance);

    }

    static boolean foo(Account too, Account from, BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        if (from.balance.compareTo(BigDecimal.ZERO) < 0 && too.balance.compareTo(BigDecimal.ZERO) < 0){
            return false;
        }

        if (from.getBalance().compareTo(amount) < 0){
            return false;
        }


        BigDecimal subtract = from.getBalance().subtract(amount);
        from.setBalance(subtract);

        BigDecimal tooAmount = too.getBalance();
        too.setBalance(tooAmount.add(amount));


        return true;
    }

}

class Account{
    public Account(int id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    int id;
    BigDecimal balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

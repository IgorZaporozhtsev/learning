package design_patterns.train;


public class StrategyPayment {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(12.21);
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setStrategy(creditCard);
        paymentContext.doPayment(20);

        PayPal payPal = new PayPal(43.12);
        paymentContext.setStrategy(payPal);
        paymentContext.doPayment(10);
    }
}

interface Payment{
    boolean pay(double amount);

}

class PaymentContext{
    Payment payment;

    void doPayment(double amount){
        payment.pay(amount);
    }

    void setStrategy(Payment payment){
        this.payment = payment;
    }
}

class CreditCard implements Payment {

    double balance;

    public CreditCard(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("CreditCard payment in progress...");
        System.out.println("Initial balance is ..." + balance);
        balance -= amount;
        System.out.println("Balance after payment..." + balance);
        System.out.println("CreditCard payment in progress...");
        return true;
    }
}

class PayPal implements Payment{

    double balance;

    public PayPal(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("PayPal payment in progress...");
        System.out.println("Initial balance is ..." + balance);
        balance -= amount;
        System.out.println("Balance after payment..." + balance);
        System.out.println("PayPal payment in progress...");
        return true;
    }
}


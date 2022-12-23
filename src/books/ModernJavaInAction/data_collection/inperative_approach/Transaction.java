package books.ModernJavaInAction.data_collection.inperative_approach;



public class Transaction {

    public Transaction(Currency currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    protected Currency currency;

    protected int value;


    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency=" + currency +
                ", value=" + value +
                '}';
    }
}

package books.ModernJavaInAction.model;


public class Transaction {

    private Currency currency;
    private int value;
    private String referenceCode;

    public Transaction(Currency currency, int value, String referenceCode) {
        this.currency = currency;
        this.value = value;
        this.referenceCode = referenceCode;
    }


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

    public void setReferenceCode(String value){
        this.referenceCode = value;
    }

    public String getReferenceCode(){
        return referenceCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency=" + currency +
                ", value=" + value +
                "referenceCode=" + referenceCode +
                '}';
    }
}

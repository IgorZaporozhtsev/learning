package books.ModernJavaInAction.data_collection.inperative_approach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainDataCollection {

    private static void aggregateTransactionByCurrency(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrency = new HashMap<>();

        for (Transaction transaction: transactions) {
            Currency currency = transaction.getCurrency();


            //get List<Transaction> by Currency as key
            List<Transaction> transactionsForCurrency = transactionsByCurrency.get(currency);

            //if key (Currency) doesn't exist yet add new List<Transactions>
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrency.put(currency, transactionsForCurrency);
            }

            //fill List<Transaction> by transaction
            transactionsForCurrency.add(transaction);

        }

        print(transactionsByCurrency);
    }


    public static void print(Map<Currency, List<Transaction>> transactionsByCurrency){
        System.out.println(transactionsByCurrency);
    }


    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction(Currency.EUR, 200),
                new Transaction(Currency.EUR, 230),
                new Transaction(Currency.USD, 125),
                new Transaction(Currency.EUR, 435),
                new Transaction(Currency.EUR, 920),
                new Transaction(Currency.USD, 1340),
                new Transaction(Currency.EUR, 124),
                new Transaction(Currency.EUR, 434),
                new Transaction(Currency.USD, 650),
                new Transaction(Currency.EUR, 330),
                new Transaction(Currency.EUR, 95)
        );


        aggregateTransactionByCurrency(transactions);

    }
}

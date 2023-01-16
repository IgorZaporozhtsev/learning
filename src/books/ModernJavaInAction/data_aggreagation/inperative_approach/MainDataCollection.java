package books.ModernJavaInAction.data_aggreagation.inperative_approach;

import books.ModernJavaInAction.model.Currency;
import books.ModernJavaInAction.model.DataGenerator;
import books.ModernJavaInAction.model.Transaction;

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


        aggregateTransactionByCurrency(DataGenerator.getAllTransactions());

    }
}

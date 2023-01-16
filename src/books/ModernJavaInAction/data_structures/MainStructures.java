package books.ModernJavaInAction.data_structures;

import books.ModernJavaInAction.model.DataGenerator;
import books.ModernJavaInAction.model.Transaction;

import java.util.Iterator;
import java.util.List;

public class MainStructures {
    public static void main(String[] args) {

        List<Transaction> transactions = DataGenerator.getAllTransactions();

        //removeIf
        for (Transaction transaction : transactions) {
            if(Character.isDigit(transaction.getReferenceCode().charAt(0))) {
                transactions.remove(transaction);
            }
        }

        for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();){
            Transaction transaction = iterator.next();
            if(Character.isDigit(transaction.getReferenceCode().charAt(0))) {
                iterator.remove();
            }
        }

        transactions.removeIf(transaction -> Character.isDigit(transaction.getReferenceCode().charAt(0)));

        //replaceAll







    }
}

package design_patterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FunctionalApproach {
    private static final Map<String, TriFunction<String, Integer, String, BankProduct>> expandedMap = Map.of(
            "loan", (currency, tax, description) -> new Loan(currency, tax, description),
            "stock", (currency, tax, description) -> new Stock(currency, tax, description),
            "bond", Bond::new
    );
    private static final Map<String, Supplier<BankProduct>> simpleMap = new HashMap<>();


    static {
        simpleMap.put("loan", Loan::new);
        simpleMap.put("stock", Stock::new);
        simpleMap.put("bond", Bond::new);
    }


    public static void main(String[] args) {
        BankProduct loan = createProduct("loan");
        loan.publishData();

        BankProduct bond = createExpandedProduct("bond", "USD", 10, "day");
        bond.publishData();

    }

    public static BankProduct createProduct(String name) {
        Supplier<BankProduct> productSupplier = simpleMap.get(name);
        if (productSupplier != null) return productSupplier.get();
        throw new IllegalArgumentException("No such product " + name);
    }

    public static BankProduct createExpandedProduct(String productName, String currency, int tax, String description) {
        TriFunction<String, Integer, String, BankProduct> product = expandedMap.get(productName);
        if (product != null) return product.apply(currency, tax, description);
        throw new IllegalArgumentException("No such product " + productName);
    }

}

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

interface BankProduct {
    void publishData();

}

class Loan implements BankProduct {
    String currency;
    int tax;
    String description;

    public Loan(String currency, int tax, String description) {
        this.currency = currency;
        this.tax = tax;
        this.description = description;
    }

    public Loan() {

    }

    @Override
    public void publishData() {
        System.out.println(
                "currency: " + currency + "\n" +
                        "tax: " + tax + "\n" +
                        "description: " + description);
    }
}

class Stock implements BankProduct {
    String currency;
    int tax;
    String description;

    public Stock(String currency, int tax, String description) {
        this.currency = currency;
        this.tax = tax;
        this.description = description;
    }

    public Stock() {

    }

    @Override
    public void publishData() {
        System.out.println(
                "currency: " + currency + "\n" +
                        "tax: " + tax + "\n" +
                        "description: " + description);
    }
}

class Bond implements BankProduct {
    String currency;
    int tax;
    String description;

    public Bond(String currency, int tax, String description) {
        this.currency = currency;
        this.tax = tax;
        this.description = description;
    }

    public Bond() {

    }

    @Override
    public void publishData() {
        System.out.println(
                "currency: " + currency + "\n" +
                        "tax: " + tax + "\n" +
                        "description: " + description);
    }
}

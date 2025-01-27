package Java8.functional_interface.use_cases.chain_function;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import static Java8.functional_interface.use_cases.chain_function.CalculationType.DISCOUNT;
import static Java8.functional_interface.use_cases.chain_function.CalculationType.TAX;

public class PricingService {
    //1. apply tax
    //2. apply discount

    public static void main(String[] args) {
        Function<BigDecimal, Function<Order, Order>> taxFunction = taxRate -> order -> {
            BigDecimal tax = order.getBasePrice().multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
            order.setTaxAmount(tax);
            return order;
        };

        Function<BigDecimal, Function<Order, Order>> discountFunction = discountRate -> order -> {
            BigDecimal discount = order.getBasePrice().multiply(discountRate).setScale(2, RoundingMode.HALF_UP);
            order.setDiscountAmount(discount);
            return order;
        };

        // Set tax and discount rates dynamically
        BigDecimal taxRate = BigDecimal.valueOf(0.15); // 15% tax
        BigDecimal discountRate = BigDecimal.valueOf(0.05); // 5% discount

        // Build the pricing pipeline dynamically
        Function<Order, Order> pricingPipeline = taxFunction.apply(taxRate).andThen(discountFunction.apply(discountRate));


        // Create an order and calculate the final price
        Order order = new Order(new BigDecimal("200.00")); // Base price = 200.00
        pricingPipeline.apply(order);

        // Print out the results
        System.out.println(order);
    }

    // Function to apply either tax or discount dynamically
    public static Function<Order, Order> applyRateFunction(BigDecimal rate, CalculationType type) {
        return order -> {
            BigDecimal amount = order.getBasePrice().multiply(rate).setScale(2, RoundingMode.HALF_UP);
            if (type == TAX) {
                order.setTaxAmount(amount);
            } else if (type == DISCOUNT) {
                order.setDiscountAmount(amount);
            }
            return order;
        };
    }

    // Method to apply tax and discount dynamically using Function composition
    public Function<Order, Order> calculatePricing(BigDecimal taxRate, BigDecimal discountRate) {
        // Create the pricing pipeline with dynamic function composition
        return applyRateFunction(taxRate, CalculationType.TAX)
                .andThen(order -> applyRateFunction(discountRate, CalculationType.DISCOUNT).apply(order));
    }

}


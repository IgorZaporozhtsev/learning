package Java8.functional_interface.function;


import java.util.function.DoubleUnaryOperator;

public class ProductApplier {
    public static void main(String[] args) {
        Product product = new Product("Clothes", 500);

        //1st
        DoubleUnaryOperator calculateDiscount = price -> calculateDiscount(product);
        DoubleUnaryOperator taxPrice = ProductApplier::calculateTax;

        DoubleUnaryOperator calculateDiscountedPriceWithTax = taxPrice.compose(calculateDiscount);

        double result = calculateDiscountedPriceWithTax.applyAsDouble(product.price);
        System.out.println("1st: " + product.name + result);

        //2nd refacor

        DoubleUnaryOperator calculateDiscountWithTax = taxPrice.compose(price -> calculateDiscount(product));
        calculateDiscountWithTax.applyAsDouble(product.price);

        System.out.println("2nd: " + product.name + result);


        //3rd with andThen
        DoubleUnaryOperator calculateDiscount3 = price -> calculateDiscount(product);
        DoubleUnaryOperator taxPrice3 = ProductApplier::calculateTax;
        DoubleUnaryOperator calculate3 = calculateDiscount3.andThen(taxPrice3);
        calculate3.applyAsDouble(product.price);

        System.out.println("3rd: " + product.name + result);


    }

    private static double calculateTax(double discountPrice) {
        return discountPrice * 0.05;
    }

    private static double calculateDiscount(Product product) {
        return product.price * 0.9;
    }

    record Product(String name, Integer price) {
    }


}

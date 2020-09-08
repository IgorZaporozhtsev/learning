package Java8.streamAPI.bigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/** In this this class we compare declarative style and functional style for BigDecimal
 *
 * https://github.com/suhyunjeon/java8lamda/blob/master/src/power/java/eight/DiscountImperative.java
 *
 * */
public class BigDecimalTest {

    public static void main(final String[] args) {
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));

        sumPriceOldVersion(prices);
        sumPriceNewVersion(prices);
    }


    /** declarative style */
    public static void sumPriceOldVersion(List<BigDecimal> prices) {
        BigDecimal totPrice = BigDecimal.ZERO;

        for(BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0)
                totPrice = totPrice.add(price.multiply(BigDecimal.valueOf(0.9)));
        }
        System.out.println("Total of discounted prices: " + totPrice);
    }

    /** functional style */
    private static void sumPriceNewVersion(List<BigDecimal> prices) {
        BigDecimal totalOfDiscountedPrices =
                prices.stream()
                        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}

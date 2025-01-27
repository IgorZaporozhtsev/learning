package Java8.functional_interface.use_cases.chain_function;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Order {
    private BigDecimal basePrice;
    private BigDecimal taxAmount = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;

    public Order(BigDecimal basePrice) {
        this.basePrice = basePrice.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalPrice() {
        return basePrice.add(taxAmount).subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Order{" +
                "basePrice=" + basePrice +
                ", taxAmount=" + taxAmount +
                ", discountAmount=" + discountAmount +
                ", finalPrice=" + getFinalPrice() +
                '}';
    }


}

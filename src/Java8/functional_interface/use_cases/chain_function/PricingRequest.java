package Java8.functional_interface.use_cases.chain_function;

import java.math.BigDecimal;

public class PricingRequest {
    private BigDecimal basePrice;
    private BigDecimal taxRate;
    private BigDecimal discountRate;

    // Getters and Setters

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }
}

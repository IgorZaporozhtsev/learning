package Java8.functional_interface.use_cases.chain_function;

import java.math.BigDecimal;
import java.util.function.Function;

//@RestController
//@RequestMapping("/api/pricing")
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    // Endpoint to calculate price with dynamic tax and discount
    //@PostMapping("/calculate")
    public Order calculatePrice(/*@RequestBody*/ PricingRequest request) {
        Order order = new Order(request.getBasePrice());
        // Get the function pipeline from the service and apply it
        Function<Order, Order> pricingFunction = pricingService.calculatePricing(request.getTaxRate(), request.getDiscountRate());
        return pricingFunction.apply(order);
    }
}


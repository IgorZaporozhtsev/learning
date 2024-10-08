package design_patterns.patterns.creation.factory;

import java.util.Map;

public class MyFactoryImpl {

    interface PaymentResources {
        void pay(double amount);
    }

    static class PayPalResource implements PaymentResources {

        @Override
        public void pay(double amount) {
            System.out.println("PayPalResource start providing payment with amount " + amount);
        }
    }

    static class StripeResource implements PaymentResources {

        @Override
        public void pay(double amount) {
            System.out.println("StripeResource start providing payment with amount " + amount);

        }
    }

    static class PaymentResourceFactory {

        Map<String, PaymentResources> paymentResources = Map.of(
                "Stripe", new StripeResource(),
                "PayPal", new PayPalResource()
        );

        public void process(String resourceName, double amount) {
            paymentResources.entrySet()
                    .stream().filter(resources ->
                            resources.getKey().equalsIgnoreCase(resourceName))
                    .forEach(resources -> resources.getValue().pay(amount));
        }
    }

    static class PaymentService {

        private final PaymentResourceFactory factory;

        PaymentService(PaymentResourceFactory factory) {
            this.factory = factory;
        }

        public void processFactory(String resourceName, double amount) {
            factory.process(resourceName, amount);
        }
    }

    public static void main(String[] args) {
        var factory = new PaymentResourceFactory();
        //RestController
        new PaymentService(factory).processFactory("PayPal", 2);


    }
}

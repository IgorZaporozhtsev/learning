package books.ModernJavaInAction.designd_patterns;

public class Strategy {
    public static void main(String[] args) {
        var numericValidator1 = new Validator(new IsNumeric());
        var lowerCaseValidator = new Validator(s -> s.matches("[a-z]+"));

        System.out.println(lowerCaseValidator.validate("aa"));
        System.out.println(numericValidator1.validate("423"));


    }

    private interface ValidationStrategy {
        boolean execute(String s);
    }

    private static class IsAllLowerCase implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    private static class IsNumeric implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    private static class Validator {
        private final ValidationStrategy strategy;

        private Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }

        private boolean validate(String s) {
            return strategy.execute(s);
        }
    }

}

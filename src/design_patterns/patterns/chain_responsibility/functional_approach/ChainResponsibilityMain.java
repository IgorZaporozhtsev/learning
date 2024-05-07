package design_patterns.patterns.chain_responsibility.functional_approach;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainResponsibilityMain {
    public static void main(String[] args) {
        UnaryOperator<String> spellChecker = ChainResponsibilityMain::checkSpell;
        UnaryOperator<String> deleteSpaces = ChainResponsibilityMain::deleteSpaces;
        UnaryOperator<String> makeLowerCase = ChainResponsibilityMain::makeLowerCase;
        Function<String, String> pipeline = spellChecker.andThen(deleteSpaces).andThen(makeLowerCase);

        String someTextInApply = pipeline.apply(" ds      Some text in apply");

        System.out.println(someTextInApply);

    }

    private static String checkSpell(String text) {
        CharSequence replace = "replace";
        CharSequence empty = Optional.ofNullable(replace).orElse("empty");
        return text.replace("ds", empty);
    }

    private static String deleteSpaces(String text) {
        return text.trim();
    }

    private static String makeLowerCase(String text) {
        return text.toLowerCase();
    }
}

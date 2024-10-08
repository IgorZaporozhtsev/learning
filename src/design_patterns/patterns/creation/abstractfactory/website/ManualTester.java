package design_patterns.patterns.creation.abstractfactory.website;

import design_patterns.patterns.creation.abstractfactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester tests website...");
    }
}

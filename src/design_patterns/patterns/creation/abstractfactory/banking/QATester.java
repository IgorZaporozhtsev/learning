package design_patterns.patterns.creation.abstractfactory.banking;

import design_patterns.patterns.creation.abstractfactory.Tester;

public class QATester implements Tester {
    @Override
    public void testCode() {
        System.out.println("QA Tester tests banking code...");
    }
}

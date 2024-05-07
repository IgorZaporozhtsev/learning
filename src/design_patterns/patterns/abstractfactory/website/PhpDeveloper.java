package design_patterns.patterns.abstractfactory.website;

import design_patterns.patterns.abstractfactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes PHP code...");
    }
}

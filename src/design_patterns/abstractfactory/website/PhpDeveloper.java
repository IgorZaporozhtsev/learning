package design_patterns.abstractfactory.website;

import design_patterns.abstractfactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes PHP code...");
    }
}

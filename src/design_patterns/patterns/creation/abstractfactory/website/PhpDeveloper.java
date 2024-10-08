package design_patterns.patterns.creation.abstractfactory.website;

import design_patterns.patterns.creation.abstractfactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes PHP code...");
    }
}

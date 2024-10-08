package design_patterns.patterns.creation.abstractfactory.banking;

import design_patterns.patterns.creation.abstractfactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}

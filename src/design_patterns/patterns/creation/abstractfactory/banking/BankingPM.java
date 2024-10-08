package design_patterns.patterns.creation.abstractfactory.banking;

import design_patterns.patterns.creation.abstractfactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manages banking project...");
    }
}

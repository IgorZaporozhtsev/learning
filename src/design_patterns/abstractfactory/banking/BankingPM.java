package design_patterns.abstractfactory.banking;

import design_patterns.abstractfactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manages banking project...");
    }
}

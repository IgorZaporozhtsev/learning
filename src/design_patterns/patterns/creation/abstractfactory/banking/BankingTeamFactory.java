package design_patterns.patterns.creation.abstractfactory.banking;

import design_patterns.patterns.creation.abstractfactory.Developer;
import design_patterns.patterns.creation.abstractfactory.ProjectManager;
import design_patterns.patterns.creation.abstractfactory.ProjectTeamFactory;
import design_patterns.patterns.creation.abstractfactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}

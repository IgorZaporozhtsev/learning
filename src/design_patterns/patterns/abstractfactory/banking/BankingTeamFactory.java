package design_patterns.patterns.abstractfactory.banking;

import design_patterns.patterns.abstractfactory.Developer;
import design_patterns.patterns.abstractfactory.ProjectManager;
import design_patterns.patterns.abstractfactory.ProjectTeamFactory;
import design_patterns.patterns.abstractfactory.Tester;

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

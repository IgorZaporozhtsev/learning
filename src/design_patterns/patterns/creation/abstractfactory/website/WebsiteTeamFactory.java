package design_patterns.patterns.creation.abstractfactory.website;

import design_patterns.patterns.creation.abstractfactory.Developer;
import design_patterns.patterns.creation.abstractfactory.ProjectManager;
import design_patterns.patterns.creation.abstractfactory.ProjectTeamFactory;
import design_patterns.patterns.creation.abstractfactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}

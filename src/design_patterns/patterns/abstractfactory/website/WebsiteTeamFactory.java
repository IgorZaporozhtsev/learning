package design_patterns.patterns.abstractfactory.website;

import design_patterns.patterns.abstractfactory.Developer;
import design_patterns.patterns.abstractfactory.ProjectManager;
import design_patterns.patterns.abstractfactory.ProjectTeamFactory;
import design_patterns.patterns.abstractfactory.Tester;

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

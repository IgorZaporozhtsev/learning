package design_patterns.patterns.creation.abstractfactory.website;

import design_patterns.patterns.creation.abstractfactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages site project...");
    }
}

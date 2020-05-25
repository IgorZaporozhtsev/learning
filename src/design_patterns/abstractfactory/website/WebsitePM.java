package design_patterns.abstractfactory.website;

import design_patterns.abstractfactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages site project...");
    }
}

package design_patterns.prototype;

public class ProjectPrototypeFactory {

    Project project;

    public ProjectPrototypeFactory(Project project) {
        this.project = project;
    }

    Project cloneProject(){
        return (Project) project.copy();
    }
}

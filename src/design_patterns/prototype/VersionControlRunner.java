package design_patterns.prototype;

public class VersionControlRunner {
    public static void main(String[] args) {
        Project master = new Project(1, "Super Project", "Source code sourceCode = new SourceCode()");
        System.out.println("It's master:      " + master);

        ProjectPrototypeFactory projectFactory = new ProjectPrototypeFactory(master);
        Project masterClone = projectFactory.cloneProject();

        System.out.println("\n It's masterClone: " + masterClone);
    }
}

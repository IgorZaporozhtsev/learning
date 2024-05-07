package design_patterns.patterns.prototype;

public class Project implements Copyable{

    private int id;
    private String name;
    private String sourceCode;

    public Project(int id, String name, String sourceCode) {
        this.id = id;
        this.name = name;
        this.sourceCode = sourceCode;
    }

    @Override
    public Object copy() {
        return new Project(id, name, sourceCode);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }
}

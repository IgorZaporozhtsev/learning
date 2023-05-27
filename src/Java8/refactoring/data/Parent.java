package Java8.refactoring.data;

import java.util.List;

public class Parent {

    List<Child> children;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}

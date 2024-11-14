package JavaCore.Generics.pecs3;

// Subclass Developer
class Developer extends Manager {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public String toString() {
        return "Developer: " + getName();
    }
}

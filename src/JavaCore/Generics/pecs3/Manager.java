package JavaCore.Generics.pecs3;

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public String toString() {
        return "Manager: " + getName();
    }
}

package books.deepcloudlabs.part_2.domain;

public class Cat extends Animal implements Pet {
    private String name;

    public Cat() {
        this("Garfield");
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.printf("%s is playing now...%n", name);
    }

    @Override
    public void eat() {
        System.out.printf("%s is eating now...%n", name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

package books.deepcloudlabs.part_2.domain;

public class Fish extends Animal implements Pet {
    private String name;

    public Fish(String name) {
        super(0);
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
        System.out.println(String.format("%s is playing now...", name));
    }

    @Override
    public void eat() {
        System.out.println(String.format("%s is eating now...", name));
    }

    @Override
    public void walk() {
        System.out.println(String.format("%s is swimming now...", name));
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                '}';
    }
}

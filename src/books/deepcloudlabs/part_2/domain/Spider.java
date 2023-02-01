package books.deepcloudlabs.part_2.domain;

public class Spider extends Animal {

    public Spider() {
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("Spider is eating now...");
    }

}

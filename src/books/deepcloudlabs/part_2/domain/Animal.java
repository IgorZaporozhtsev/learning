package books.deepcloudlabs.part_2.domain;


public abstract class Animal {
    private int legs;

    public Animal(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void walk() {
        System.out.println(
                String.format("Animal with %d legs is walking now...", legs)
        );
    }

    public abstract void eat(); // abstract method

    @Override
    public String toString() {
        return "Animal{" +
                "legs=" + legs +
                '}';
    }
}

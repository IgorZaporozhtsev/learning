package design_patterns.prototype2;

public class PrototypeApp {
    public static void main(String[] args) {
        Human original = new Human(18, "Zorg");
        System.out.println(original);

        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human copy2 = factory.makeCopy();
        System.out.println(copy2);
    }
}

interface Copyable{
    Object copy();
}

class Human implements Copyable{
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Human(age, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}

class HumanFactory{
    Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    Human makeCopy(){
        return (Human) human.copy();
    }
}


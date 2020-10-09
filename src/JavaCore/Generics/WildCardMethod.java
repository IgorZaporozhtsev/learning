package JavaCore.Generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardMethod {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1));
        animals.add(new Animal(2));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        test(animals);
        test(dogs);

    }

    private static void test(List<? extends Animal> list){ //wildcard
        for (Animal animal : list) {
            animal.eat();
        }

    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }
}

class Animal {

    private int id;

    public Animal(){

    }

    public Animal(int id){
        this.id = id;
    }

    public void eat() {
        System.out.println("Animal eating...");
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

package Java8.anonym_class.ex2;

public class DiffAnonymClass {

    public static void main(String[] args) {

        // 1.
        AbleToEat toEatMeat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("1. eat Meat - use Anonymous class");
            }
        };

        // 2.
        AbleToEat toEatCheese = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("2. eat Cheese - use Anonymous class");
            }
        };

        // 3.
        AbleToEat toEatPorridge = () -> System.out.println("3. eat Porridge - use Lambda");

        // 4.
        AbleToEat toEatAnimalFood = new Animal() {
            @Override
            public void eat() {
                System.out.println("4. eat Animal food - use Anonymous class");
                super.eat();
            }
        };


        toEatMeat.eat(); //1.
        toEatCheese.eat();//2.
        toEatPorridge.eat();//3.
        toEatAnimalFood.eat();//4.
    }
}

interface AbleToEat{
    void eat();
}

class Animal implements AbleToEat{

    @Override
    public void eat() {
        System.out.println("4.1 I am Animal from Animal class");
    }
}

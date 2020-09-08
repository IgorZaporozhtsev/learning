package interview.core.oop.polimorphizm.staticPoli;

public class Main {

    public static void main(String[] args) {

        //static Polymorphism and load method (перегруженые методы)

        Birds birds = new Birds();
        Ostrich ostrich = new Ostrich();

        ostrich.walk();
        ostrich.walk("Bla");



    }
}

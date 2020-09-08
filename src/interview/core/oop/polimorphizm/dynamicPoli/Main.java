package interview.core.oop.polimorphizm.dynamicPoli;

public class Main {


    public static void main(String[] args) {

        //динамический полиморфизм

        Birds ostrich = new Ostrich();
        Birds crow = new Crow();
        Test test = new Test();

        test.foo(ostrich);
        test.foo(crow);
    }


}

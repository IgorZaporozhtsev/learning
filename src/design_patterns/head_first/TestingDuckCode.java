package design_patterns.head_first;

public class TestingDuckCode {
    public static void main(String[] args) {
        MallardDuk mallardDuk = new MallardDuk();
        mallardDuk.setFlyBehavior(new FlyWithWings());
        mallardDuk.setQuackBehavior(new Quack());
        mallardDuk.performQuack();
        mallardDuk.performFly();
        mallardDuk.display();
    }
}


package design_patterns.head_first.strategy;

public class TestingDuckCode {
    public static void main(String[] args) {
        Duck mallardDuk = new MallardDuk();
        mallardDuk.setFlyBehavior(new FlyWithWings());
        mallardDuk.setQuackBehavior(new Quack());

        mallardDuk.performQuack();
        mallardDuk.performFly();
        mallardDuk.display();

        Duck modelDuck = new ModelDuck();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.setQuackBehavior(new Quack());
        modelDuck.performFly();
        modelDuck.performQuack();
        modelDuck.display();

    }
}


package design_patterns.head_first;

class MallardDuk extends Duck {

//    public MallardDuk() {
//        setFlyBehavior(new FlyNoWay());
//        setQuackBehavior(new MuteQuack());
//    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}

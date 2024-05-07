package design_patterns.head_first.strategy;

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

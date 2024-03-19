package design_patterns.head_first;

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

package JavaCore.inheritance;

public class Child1 extends Base {
    public int number;

    Child1(int count, int number) {
        super(count);
        this.number = number;
        System.out.println("Constructor of Child1 class" + number);
    }
}

package JavaCore.inheritance;

public class Child2 extends Child1 {
    public int number;

    Child2(int count, int number) {
        super(count, number);
        this.number = number;
        System.out.println("Constructor of Child2 class" + number);
    }

}

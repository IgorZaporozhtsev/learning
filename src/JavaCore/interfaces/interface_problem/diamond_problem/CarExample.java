package JavaCore.interfaces.interface_problem.diamond_problem;


/**
 * https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
 */

public class CarExample implements Child2, Child1 {

    public static void main(String[] args) {
        CarExample carExample = new CarExample();
        carExample.move();
    }

    /**
     * like in Rule 3 {@link JavaCore.interfaces.interface_problem.needs_override.CarExample}
     * we have to {@Override} method
     */

    @Override
    public void move() {
        System.out.println("My own implementation using @Override");
    }
}

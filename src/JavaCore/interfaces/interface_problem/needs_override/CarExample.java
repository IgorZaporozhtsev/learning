package JavaCore.interfaces.interface_problem.needs_override;


/**
 * https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
 * */

public class CarExample implements InterfaceVehicle, InterfaceCircle {

  public static void main(String[] args) {
    CarExample carExample = new CarExample();
    carExample.move();
  }

  /**
   * Rule 3 – In case Rule 1 and Rule 2 are not able to resolve the conflict then the implementing class
   * has to specifically override and provide a method with the same method definition
   * <p>
   * If we implement two interfaces {@link InterfaceVehicle#move()}, {@link InterfaceCircle#move()}
   * with same default methods in implementation class we have to {@Override}
   * and write own logic {@link CarExample#move()}
   */
  @Override
  public void move() {
    System.out.println("Override move method both Interfaces");
  }
}

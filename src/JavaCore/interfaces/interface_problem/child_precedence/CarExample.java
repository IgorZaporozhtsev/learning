package JavaCore.interfaces.interface_problem.child_precedence;

/**
 * https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
 */

public class CarExample implements InterfaceParent, InterfaceChild {

  /**
   * Rule 2 – Derived interfaces or sub-interfaces take higher precedence than the interfaces higher-up in the inheritance hierarchy
   * will invoke method {@link InterfaceChild#move()}  not parent {@link InterfaceParent#move()}
   */

  public static void main(String[] args) {
    CarExample carExample = new CarExample();
    carExample.move();
  }

}

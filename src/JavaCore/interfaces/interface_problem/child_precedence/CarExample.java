package JavaCore.interfaces.interface_problem.child_precedence;

/**
 * https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
 */

public class CarExample implements InterfaceCircle, InterfaceVehicle {

  public static void main(String[] args) {
    CarExample carExample = new CarExample();
    carExample.moveCircle();
    carExample.moveVehicle();
  }

}

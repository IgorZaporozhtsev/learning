package JavaCore.interfaces.interface_problem.classes_higher_interfaces;

/**
 * https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
 * */

public class CarExample extends Truck implements InterfaceVehicle {

  public static void main(String[] args) {
    /**
     * Rule 1 – Classes take higher precedence than interfaces
     * will invoke method {@link Truck#move()}  not interfaces default methods {@link InterfaceCircle#move()} or
     * {@link InterfaceVehicle#move()}
     * */
    CarExample carExample = new CarExample();
    carExample.move();
  }

}

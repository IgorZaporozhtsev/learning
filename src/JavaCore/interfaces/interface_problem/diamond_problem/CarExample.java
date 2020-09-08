package JavaCore.interfaces.interface_problem.diamond_problem;


/**
 * https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
 * */

public class CarExample implements InterfaceVehicle, InterfaceCircle {

  public static void main(String[] args) {
    CarExample carExample = new CarExample();
    carExample.move();
  }


  @Override
  public void move() {

  }
}

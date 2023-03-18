package JavaCore.interfaces.interface_problem.child_precedence;

public interface InterfaceVehicle extends InterfaceCircle {

  default void moveVehicle() {
    System.out.println("I am child interface moveVehicle");
  }

}

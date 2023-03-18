package JavaCore.interfaces.interface_problem.child_precedence;

public interface InterfaceChild extends InterfaceParent {

  default void move() {
    System.out.println("I am child interface moveVehicle");
  }

}

package JavaCore.interfaces.interface_problem.child_precedence;

public interface InterfaceCircle {

  default void moveCircle() {
    System.out.println("I am parent interface moveCircle");
  }
}

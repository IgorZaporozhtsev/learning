package JavaCore.interfaces.interface_problem.needs_override;

public interface InterfaceCircle {

  default void move(){
    System.out.println("moveCircle");
  }
}

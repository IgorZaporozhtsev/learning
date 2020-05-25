package JavaCore.interfaces.interface_problem.diamond_problem;

public interface InterfaceCircle extends Disk {

  default void move(){
    System.out.println("moveCircle");
  }
}

package JavaCore.interfaces.interface_problem.diamond_problem;

public interface InterfaceVehicle extends Disk {

  default void move(){
    System.out.println("moveVehicle");
  }

}

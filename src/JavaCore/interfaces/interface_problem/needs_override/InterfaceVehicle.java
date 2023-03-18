package JavaCore.interfaces.interface_problem.needs_override;

public interface InterfaceVehicle {

  default void move(){
    System.out.println("move Vehicle");
  }

}

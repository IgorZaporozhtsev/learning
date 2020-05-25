package JavaCore.interfaces.interface_problem.classes_higher_interfaces;

public interface InterfaceVehicle extends InterfaceCircle{

  default void move(){
    System.out.println("moveVehicle");
  }

}

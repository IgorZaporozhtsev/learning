package JavaCore.interfaces.interface_problem.diamond_problem;

public interface Disk {
  default void move(){
    System.out.println("moveDisk");
  }
}

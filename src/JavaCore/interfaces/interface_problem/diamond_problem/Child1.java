package JavaCore.interfaces.interface_problem.diamond_problem;

public interface Child1 extends GrandParent {

  default void move() {
    System.out.println("I'm child 1");
  }
}

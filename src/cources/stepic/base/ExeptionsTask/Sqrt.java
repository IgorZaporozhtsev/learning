package cources.stepic.base.ExeptionsTask;

public class Sqrt {


    public static void main(String[] args)  {

      try {
          System.out.println(sqrt(-16));
      }
      catch (Exception e){
         System.out.println(e.getMessage());
      }


    }

    public static double sqrt(double x) throws IllegalArgumentException {
        if (x < 0 ) throw new IllegalArgumentException ("Expected non-negative number, got" + x);
         return Math.sqrt(x);
    }
}

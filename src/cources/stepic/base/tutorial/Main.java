package cources.stepic.base.tutorial;

/**
 * Created by Igor on 28.09.2017.
 */
public class Main {
    public static void main(String[] args) {


        Shapes shapes1 = new Shapes();
        Circle shapes2 = new Circle();

        shapes1.vivod();
        shapes2.vivod();

        Shapes shapes = CircleFabrike.getCircle();


    }
}

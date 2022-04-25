package solid.dependencyinversion;

import java.util.List;

public class Main {
//https://www.youtube.com/watch?v=_jDNAf3CzeY&ab_channel=Amigoscode

    public static void main(String[] args) {
        Calculator areaCalculator = new AreaCalculator();
        Circle circle = new Circle(10);
        Square square = new Square(10);
        //expand functionality by add new class and implement interface
        Cube cube = new Cube();
        // we add new functionality like Rectangle and don't modify AreaCalculator anymore


        /**
         * look at ShapesPrinter class
         * */
        ShapesPrinter printer = new ShapesPrinter(areaCalculator);
        List<Shape> shapes = List.of(circle, square, cube);
        ///int sum = areaCalculator.sum(shapes);

        System.out.println(printer.json(shapes));
        System.out.println(printer.csv(shapes));
    }
}

package solid.singleresposibility;

import java.util.List;

public class Main {
//https://www.youtube.com/watch?v=_jDNAf3CzeY&ab_channel=Amigoscode
    //in master wrong implementation that break particular solid principle
    // in solid-resolve brunch is correct implementation

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();
        ShapesPrinter printer = new ShapesPrinter();
        Circle circle = new Circle(10);
        Square square = new Square(10);
        List<Object> shapes = List.of(circle, square);
        int sum = areaCalculator.sum(shapes);
        System.out.println(printer.json(sum));
        System.out.println(printer.csv(sum));
    }
}

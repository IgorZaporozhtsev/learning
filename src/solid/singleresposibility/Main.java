package solid.singleresposibility;

import java.util.List;

public class Main {
//https://www.youtube.com/watch?v=_jDNAf3CzeY&ab_channel=Amigoscode

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();
        Circle circle = new Circle(10);
        Square square = new Square(10);
        List<Object> shapes = List.of(circle, square);
        int sum = areaCalculator.sum(shapes);
        System.out.println("sum = " + sum);
    }
}

package solid.openclosed.ex1;

import java.util.List;

public class Main {
//https://www.youtube.com/watch?v=_jDNAf3CzeY&ab_channel=Amigoscode

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();
        Circle circle = new Circle(10);
        Square square = new Square(10);
        //expand functionality by add new class and implement interface
        Cube cube = new Cube();
        // we add new functionality like Rectangle and don't modify AreaCalculator anymore

        ShapesPrinter printer = new ShapesPrinter();
        List<Shape> shapes = List.of(circle, square, cube);

        /**
         * Передавая в метод AreaCalculator#sum список фигур внутри метода в зависимости от типа выбираеться реализация
         *
         * */
        int sum = areaCalculator.sum(shapes);


        System.out.println(printer.json(sum));
        System.out.println(printer.csv(sum));
    }
}

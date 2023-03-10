package solid.openclosed.ex1;

import java.util.List;

public class AreaCalculator {
    public int sum(List<Shape> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++){
            Shape shape = shapes.get(i);
            sum += shape.area();
        }
        return sum;
    }
/**
 * Используя старый метод sum() нам понадобиться расширить его добавив "shape instanceof Cube"
 * тем самым мы измененяем класс но про приципу OpenClosed он должен быть открыт для расширения и закрыт для модификации - изменения
 *
 * Что решить это мы создадим интерфейс Shape который будут реализовывать все наши фигуры
 *
 *
 *
 * */

/*
    public int sum(List<Object> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++){
            Object shape = shapes.get(i);


            if (shape instanceof  Square){
                sum += Math.pow(((Square) shape).getLength(), 2);
            }

            if (shape instanceof Circle){
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);

            }

            if (shape instanceof Cube){
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);

            }

        }
        return sum;
    }*/
}

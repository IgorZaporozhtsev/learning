package solid.singleresposibility;

import java.util.List;

public class AreaCalculator {
    public int sum(List<Object> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++){
            Object shape = shapes.get(i);
            if (shape instanceof Square){
                sum += Math.pow(((Square) shape).getLength(), 2);
            }
            if (shape instanceof Circle){
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);

            }
        }
        return sum;
    }

/**
 * Добавляяя в класс эти методы мы нарушаем прицип SingleResponsibility
 * потому как этот клас отвечает только за постчет калькуляци не должен заниматься печатанием
 * результата в разных форматах
 * Для этого мы зоздадим другой класс
 * ShapesPrinter
 *
 * */

//    public String json(int sum){
//        return "{sum: %s}".formatted(sum);
//    }
//
//    public String csv(int sum){
//        return "sum, %s".formatted(sum);
//    }

}

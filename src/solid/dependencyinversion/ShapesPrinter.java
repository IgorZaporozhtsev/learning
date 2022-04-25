package solid.dependencyinversion;

import java.util.List;

//this class has one responsibility
public class ShapesPrinter {

    /**
     * private AreaCalculator areaCalculator = new AreaCalculator();
     * первая проблема - это мы нарушаем OpenClosed тем что используя класс а не интерфейс так как в случи если мы заходим сделать изменения
     *          на прийдеться добавлять код в класс а не создавать новыкласс (новую реализацию интерфейса)
     * вторая проблема - зависим от конкретного класса не от Абстракции, если бы удалим этот класс то появиться ошибка в этом классе
     * так как эти класы тесто связаны между собой
     * Нужно создать интерфейс и использовать его реализации public IAreaCalculator areaCalculator;
     *
     * */
    private final Calculator areaCalculator;

    public ShapesPrinter(Calculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }

    public String json(List<Shape> shapes){
        return "{sum: %s}".formatted(areaCalculator.sum(shapes));
    }

    public String csv(List<Shape> shapes){
        return "sum, %s".formatted(areaCalculator.sum(shapes));
    }
}
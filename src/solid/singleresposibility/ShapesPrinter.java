package solid.singleresposibility;

import java.util.List;

/**
this class has one responsibility
 этот класс делает только одно печатает в рахных форматах
 */
public class ShapesPrinter {

    public String json(int sum){
        return "{sum: %s}".formatted(sum);
    }

    public String csv(int sum){
        return "sum, %s".formatted(sum);
    }
}

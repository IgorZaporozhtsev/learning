package solid.liskovsubstitution;

public class NoShape implements Shape{


    /**
     * нарушает прицип Барбары Лисков потому как реализация базового класса (интерфейса) заложеная в метод area совсем другая
     *
     * */
    @Override
    public double area() {
       throw new IllegalStateException("Cannot calculate area");
    }
}

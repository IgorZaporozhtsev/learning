package interview.core.oop.polimorphizm.dynamicPoly2;

public class Shape {    // вместо класса Shape можносоздать interface Shape
    public void draw(){
        System.out.println("drawing just Shape");
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Shape shape = new Shape();

        test(circle); //подставляем реализацию Круг
        test(square); //подставляем реализацию Квадрат
        test(shape); //подставляем реализацию Круг


        Shape circle2 = new Circle();
        circle2.draw();
    }
    // в shape можем подставить разные реализации которые implements Shape
    public static void test(Shape shape){
        shape.draw();

    }

}

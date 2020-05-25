package interview.core.oop.polimorphizm.dynamicPolu3;

public class PolymorphismExample {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();
        test(circle);
        test(square);
    }

    static void test(Shape shape){
        shape.draw();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("I'm drawing Circle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("I'm drawing Square");
    }
}

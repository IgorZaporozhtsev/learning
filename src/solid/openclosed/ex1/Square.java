package solid.openclosed.ex1;

public class Square implements Shape {
    private final int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getLength(), 2);
    }
}

package solid.interfacesegregation;

public class Square implements Shape, ThreeDimensionalShape {
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

    @Override
    public double volume() {
        return 0;
    }
}
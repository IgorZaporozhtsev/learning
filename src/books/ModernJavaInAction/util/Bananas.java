package books.ModernJavaInAction.util;

public class Bananas {

    private final Color color;
    private int weight;

    public Bananas(Color color) {
        this.color = color;
    }

    public Bananas(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }


    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}

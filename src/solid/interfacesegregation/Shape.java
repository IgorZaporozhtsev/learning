package solid.interfacesegregation;

public interface Shape {
    double area();
    /**
     * мы не можем добавить метод volume() ( обьем ) в этот интерфейс так как у нас есть наследник Circle который не может иметь обьема
     * поэтому мы создадим новый интерфейс ThreeDimensionalShape
     * */

    //double volume();
}

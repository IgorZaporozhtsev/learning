package cources.stepic.base.IO;

        import java.io.*;

public class Animal {
    public static void main(String[] args) {
    }

    public static Animal[] deserializeAnimalArray(byte[] data)  {
        int size = 0;

        try {
            ByteArrayInputStream byteArray = new ByteArrayInputStream(data);
            ObjectInputStream inputStream = new ObjectInputStream(byteArray);
            size = inputStream.readInt();
            Animal [] animals = new Animal[size];

            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) inputStream.readObject();
            }

            inputStream.close();
            return animals;

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}

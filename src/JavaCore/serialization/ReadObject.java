package JavaCore.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("people.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            System.out.println(person1.toString());
            System.out.println(person2.toString());

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

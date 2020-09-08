package JavaCore.serialization;

import java.io.*;

public class WriteObject {
    public static void main(String[] args) {

        Person person1 = new Person(1, "Bod");
        Person person2 = new Person(2, "Mike");



        try (FileOutputStream fos = new FileOutputStream("people.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

                oos.writeObject(person1);
                oos.writeObject(person2);

            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

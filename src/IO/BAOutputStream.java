package IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BAOutputStream {

    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        String text = "Hello Wolrd!";

        byte[] buffer = text.getBytes();

        baos.write(buffer);

        // превращаем массив байтов в строку
        System.out.println(baos.toString());

        // получаем массив байтов и выводим по символьно
        byte[] array = baos.toByteArray();
        for(byte b: array){

            System.out.print((char)b);
        }
        System.out.println();
    }
}

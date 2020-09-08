package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskFIS_2 {
    public static void main(String[] args) throws IOException {

        FileInputStream fin=new FileInputStream("c://Users//Igor//Documents//notes.txt");
            FileOutputStream fos=new FileOutputStream("c://Users//Igor//Documents//notes_2.txt");

            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
    }
}

package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TaskFIS {


    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream("c://Users//Igor//Documents//notes.txt");
            System.out.printf("File size: %d bytes \n", fin.available());

            int i= 0;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }

    }
}

package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TaskFIS {
//
//
//    public static void main(String[] args) throws IOException {
//
//        FileInputStream fin = new FileInputStream("c://Users//Igor//Documents//notes.txt");
//            System.out.printf("File size: %d bytes \n", fin.available());
//
//            int i= 0;
//            while((i=fin.read())!=-1){
//
//                System.out.print((char)i);
//            }
//
//    }



        public static void main(String[] args) {
            int numberOfRabbits = 10; // количество зайцев на входе
            int totalEars = countEars(numberOfRabbits);
            System.out.println("Общее количество ушей: " + totalEars);
        }

        public static int countEars(int rabbits) {
            // Базовый случай: если нет зайцев, то и ушей 0
            if (rabbits == 0) {
                return 0;
            }
            // Рекурсивный случай: каждый заяц имеет 2 уха, плюс остальные зайцы
            // Минус один заяц, потому что мы уже учли одного
            int i = countEars(rabbits - 1);
            System.out.println(i);
            return 2 + i;
        }

}

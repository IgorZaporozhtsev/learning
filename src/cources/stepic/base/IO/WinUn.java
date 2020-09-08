package cources.stepic.base.IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class WinUn {
    public static void main(String[] args) throws IOException {

        ByteArrayInputStream byteStream = new ByteArrayInputStream(new byte[]{65, 13, 10, 13, 10, 10, 13, 65});

        //  Если 13 10 меняем на 10
        //  Если просто 13 оставляем 13

        int input1 = byteStream.read();
        int input2 = byteStream.read();
        while (input1 != -1) {
            if (input1 == 13 && input2 == 10) {
                System.out.print(" " + input2);
                input1 = byteStream.read();
                input2 = byteStream.read();
            } else {
                System.out.print(" " + input1);
                input1 = input2;
                input2 = byteStream.read();
            }
            System.out.flush();
            byteStream.close();
        }
    }
}
package cources.stepic.base.IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOStream {
    public static void main(String[] args) throws IOException {
        InputStream stream = new ByteArrayInputStream( new byte[] { 0x33, 0x45, 0x01});
        System.out.println(checkSumOfStream(stream));
    }


    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here

        int totalSum = 0;
        int n = 0;
        while ((n = inputStream.read()) != -1){
            totalSum = Integer.rotateLeft(totalSum, 1) ^ n;
        }



        return totalSum;
    }
}

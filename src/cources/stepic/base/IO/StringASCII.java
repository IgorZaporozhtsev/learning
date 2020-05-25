package cources.stepic.base.IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringASCII {
    public static void main(String[] args) throws IOException {

        InputStream stream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        Charset charset = StandardCharsets.US_ASCII;
        System.out.println(readAsString(stream, charset));


    }


    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {

        StringBuilder string = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream, charset);
        int data;

        while ((data = reader.read()) != -1) {
            string.append((char) data);
            // Character.toChars(iChar))
        }

        return string.toString();

    }
}

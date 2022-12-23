package books.ModernJavaInAction.execute_around_pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainProcess {

    public static void main(String[] args) throws IOException {
       //using usual approach
        System.out.println( processFile());

        //functional approach
        String s = processFile(br -> br.readLine() + ", " + br.readLine());
        System.out.println(s);

    }

    //usual approach
    private static String processFile() throws IOException {

        String rootPath = "src/books/ModernJavaInAction/execute_around_pattern";

        try
            (var br = new BufferedReader(new FileReader(rootPath + "/data.txt"))) {
            return br.readLine();
        }

    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader br) throws IOException;
    }

    //functional approach
    private static String processFile(BufferedReaderProcessor processor) throws IOException {
        String rootPath = "src/books/ModernJavaInAction/execute_around_pattern";
        try
                (var br = new BufferedReader(new FileReader(rootPath + "/data.txt"))) {
            return processor.process(br);
        }
    }

}

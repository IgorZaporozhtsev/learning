package Java8.basics2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        printStatistic(file);
    }

    public static void printStatistic(File file) throws IOException {
                Files.lines(Paths.get(file.getAbsolutePath()))
                .map(n -> n.toUpperCase())
                .flatMapToInt(n -> n.chars())
                .filter(n -> n >= 'A' && n <= 'Z')
                .mapToObj((n) -> (Character.valueOf((char)n)))
                .collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream()
                .sorted((a,b) -> (int) (a.getValue() - b.getValue()))
                .forEach(n -> System.out.println(n));

    }
}

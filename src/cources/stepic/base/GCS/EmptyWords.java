package cources.stepic.base.GCS;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;
        import java.util.function.Function;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class EmptyWords {

    public static void main(String[] args) throws IOException {
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non," +
                " faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. " +
                "Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, " +
                "ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        List <String> list = new ArrayList<>();
        list.add(s);

        Stream<String> stream = reader.lines();


        Map<String, Long> collect =

                list.stream()

                        .map(w -> w.toLowerCase()
                        .split("[^\\p{L}\\p{Digit}_]+"))

                        .flatMap(Arrays::stream)

                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Map<String, Long> finalMap = new LinkedHashMap<>();
        collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed().thenComparing(Map.Entry.<String, Long>comparingByKey()))
                .limit(10)
                .map(r -> r.getKey())
                .forEach(System.out::println);






    }
}

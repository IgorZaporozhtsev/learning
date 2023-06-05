package interview.livecoding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class HashTagStream {

    public static void main(String[] args) {
        var twits = new ArrayList<String>();
        twits.add("#Java and #Scala are the languages of cognitive and AI development. IBM sees cognitive development is the future.");
        twits.add("Some more info on the IBM investment in #Scala and Lightbendhttp8/ibm-lightbend-join-forces-enterpri");
        twits.add("IBM and @Lightbend are bulding an integrated platform for #Java and #Scala #cognitive app development");
        String tags = "Java, Scala, cognitive";
        var hastTags = getHastTags(twits);
        hastTags.forEach(System.out::println);
    }

    public static List<String> getHastTags(List<String> twits){

        var retrievedTags = retrieveTags(twits);
        Map<String, Long> tagsMap = collectToMap(retrievedTags);

        ArrayList<String> tags = new ArrayList<>(tagsMap.keySet());
        Collections.reverse(tags);

        return tags;
    }

    private static List<String> retrieveTags(List<String> twits) {
        return twits.stream()
                .map(t -> t.split(" "))
                .flatMap(Stream::of) //in implementation it uses Arrays::stream
                .filter(s -> s.contains("#"))
                .toList();
    }

   private static Map<String, Long> collectToMap(List<String> list) {
       Collector<String, ?, Map<String, Long>> stringMapCollector = groupingBy(Function.identity(), counting());
       return list.stream()
                .collect(stringMapCollector)
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b) -> b, LinkedHashMap::new));
    }
}

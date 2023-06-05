package interview.livecoding;

import java.util.*;

public class HashTag {

    public static void main(String[] args) {
        var twits = new ArrayList<String>();
        twits.add("#Java and #Scala are the languages of cognitive and AI development. IBM sees cognitive development is the future.");
        twits.add("Some more info on the IBM investment in #Scala and Lightbendhttp8/ibm-lightbend-join-forces-enterpri");
        twits.add("IBM and @Lightbend are bulding an integrated platform for #Java and #Scala #cognitive app development");

        String tags = "Java, Scala, cognitive";
        var hastTags = getHastTags(twits);
        hastTags.forEach(System.out::println);
    }

    public static ArrayList<String> getHastTags(List<String> twits){

        HashMap<String, Integer> mappedTags = retrieveTagsFromText(twits);

        ArrayList<Map.Entry<String, Integer>> listOfMappedTags = new ArrayList<>(mappedTags.entrySet());

        listOfMappedTags.sort(Map.Entry.comparingByValue());

        return extractKeysToListWithOrder(listOfMappedTags);


    }

    private static ArrayList<String> extractKeysToListWithOrder(ArrayList<Map.Entry<String, Integer>> list) {
        ArrayList<String> tags = new ArrayList<>();

        for (var entry: list) {
            String key = entry.getKey();
            tags.add(key);
        }

        Collections.reverse(tags);

        return tags;
    }

    private static HashMap<String, Integer> retrieveTagsFromText(List<String> twits) {

        var map = new HashMap<String, Integer>();

        for (String twit : twits) {
            String[] line = twit.split(" ");
            for (String tag : line) {
                if (tag.contains("#")) {
                    if (Objects.isNull(map.get(tag))) {
                        map.put(tag, 0);
                    }
                    Integer count = map.get(tag);
                    map.put(tag, count + 1);
                }
            }
        }
        return map;
    }
}

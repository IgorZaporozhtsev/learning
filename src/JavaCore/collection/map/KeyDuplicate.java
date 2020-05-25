package JavaCore.collection.map;

import java.util.HashMap;
import java.util.Map;

public class KeyDuplicate {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("1", "2");
        for( Map.Entry<String, String> entry : map.entrySet() ){
            System.out.println( entry.getKey() + " " + entry.getValue() );
        }
// Output: 1 2
    }
}

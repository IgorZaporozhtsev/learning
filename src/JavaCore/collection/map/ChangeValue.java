package JavaCore.collection.map;

import java.util.HashMap;
import java.util.Map;

public class ChangeValue {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        for( Map.Entry<String, String> entry : map.entrySet() )
            if( "2".equals( entry.getKey() ) )
                entry.setValue( "x" );

        System.out.println( map );
// Output: {3=c, 2=x, 1=a}
    }
}

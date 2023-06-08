package JavaCore.collection.set;

import java.util.HashSet;

public class SetPresentRemove {
    public static void main(String[] args) {
        var set = new HashSet<String>();
        set.add("first");
        set.add("second");

        for (String s : set) {
            System.out.println(s);
        }

        set.remove(null);


    }
}

package JavaCore.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Program {
    String nameKey;

    public Program(String nameKey) {
        this.nameKey = nameKey;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(nameKey, program.nameKey);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(nameKey);
        System.out.println(hash);
        return hash;
    }

    public static void main(String[] args) {
        Map map1 = new HashMap();
        map1.put("Hello", 99);



    }


}

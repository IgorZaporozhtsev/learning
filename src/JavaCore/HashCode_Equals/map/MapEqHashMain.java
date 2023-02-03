package JavaCore.HashCode_Equals.map;

import java.util.HashMap;

public class MapEqHashMain {
    public static void main(String[] args) {
        MyClass first = new MyClass("a", "first");
        MyClass second = new MyClass("a", "second");
        MyClass third = new MyClass("a", "second");

        var myClassHashMap = new HashMap<MyClass, Integer>();
        myClassHashMap.put(first, 32);
        myClassHashMap.put(second, 3);
        myClassHashMap.put(third, 55);

        //Override only equals
        //if we don't override hashCode first, second will be present in bucket
        myClassHashMap.forEach((k, v) -> System.out.println("key - " + k + " : " + "value - " + v));

        //Override only hashCode


    }


}


class MyClass {
    private final String importantField;
    private final String anotherField;

    public MyClass(final String equalField, final String anotherField) {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MyClass other = (MyClass) obj;
        if (importantField == null) {
            if (other.importantField != null)
                return false;
        } else if (!importantField.equals(other.importantField))
            return false;
        return true;
    }
}

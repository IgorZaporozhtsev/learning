package JavaCore.collection.map.map;

import java.util.HashMap;
import java.util.Objects;

public class MapEqHashMain {
    public static void main(String[] args) {
        MyClass first = new MyClass("a", "first");  System.out.println("first : " + first.getImportantField() + " hashCode is: " + first.hashCode());
        MyClass second = new MyClass("a", "first"); System.out.println("second : " + second.getImportantField() + " hashCode is: " + second.hashCode());
        MyClass third = new MyClass("a", "first"); System.out.println("third : " + third.getImportantField() + " hashCode is: " + third.hashCode());

        var myClassHashMap = new HashMap<MyClass, Integer>();
        myClassHashMap.put(first, 55);
        myClassHashMap.put(second, 42);
        myClassHashMap.put(third, 123);
        //Override only equals
        //if we don't override hashCode first, second will be present in bucket
        System.out.println("value: " + myClassHashMap.get(third));

        myClassHashMap.forEach((k, v) -> System.out.println("key - " + k + " : " + "value - " + v));
        System.out.println(myClassHashMap.size());

        //Override only hashCode

    }


}


class MyClass {
    private  String importantField;
    private  String anotherField;

    public MyClass( String equalField,  String anotherField) {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    public String getImportantField() {
        return importantField;
    }

    public String getAnotherField() {
        return anotherField;
    }

    @Override
    public int hashCode() {
        return 1;//Objects.hash(importantField, anotherField);
    }


    /*   @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }*/


/*    @Override
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
    }*/


    @Override
    public String toString() {
        return "MyClass{" +
                "importantField='" + importantField + '\'' +
                ", anotherField='" + anotherField + '\'' +
                '}';
    }
}

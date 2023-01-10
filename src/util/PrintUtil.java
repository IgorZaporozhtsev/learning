package util;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PrintUtil {



    public static <K,V> void print(Map<K,V> map){
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    public static  <T, R> void printMapOfList(Map<T, List<R>> map){

        for ( Map.Entry<T, List<R>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(value-> System.out.println("     "+value));

        }
    }

    public static  <T, R> void printMapOfOptional(Map<T, Optional<R>> map){

        for ( Map.Entry<T, Optional<R>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("     "+entry.getValue());

        }
    }

    public static  <T, R, K> void printMapOfMap(Map<T, Map<R, List<K>>> map){
        for ( Map.Entry<T, Map<R, List<K>>> entry :map.entrySet()) {
            System.out.println(entry.getKey() + ":");


            for (Map.Entry<R, List<K>> value: entry.getValue().entrySet()) {
                System.out.println("     "  + value.getKey() + ":");
                value.getValue().forEach(val -> System.out.println("           "+val));
            }

        }
    }
}

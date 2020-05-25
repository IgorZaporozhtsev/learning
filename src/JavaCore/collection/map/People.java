package JavaCore.collection.map;

import java.util.Objects;

public class People {

    private int age;
    private String name;

     public People(int age, String name){
        this.age = age;
        this.name = name;

    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }



}

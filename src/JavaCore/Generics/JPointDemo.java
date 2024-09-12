package JavaCore.Generics;

import java.util.ArrayList;
import java.util.List;

public class JPointDemo {
    public static void main(String[] args) {
        Manager[] managers = new Manager[10];
        Person[] persons = managers;
        persons[0] = new Person(); //ArrayStoreException


        List<?> lists = new ArrayList<>();
        //lists.add(new Manager()); //Required type: capture of ?
    }

}

class Person{}
class Manager extends Person{}

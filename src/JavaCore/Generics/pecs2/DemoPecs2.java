package JavaCore.Generics.pecs2;

import java.util.ArrayList;
import java.util.List;

public class DemoPecs2 {
    public static void main(String[] args) {
        //Person <- Employee <- Manager

        List<Person> list = new ArrayList<>();
        list.add(new Person("Person"));
        list.add(new Employee("Employee"));
        list.add(new Manager("Manager"));

        processLowerBounded(list);

        //processUpperBounded(list);
    }

    //Producer
    public static void processUpperBounded(List<? extends Employee> employees){
        //employees.add(new Person("new Person")); //capture of ? extends Employee
        Employee employee = employees.getFirst();
        System.out.println(employee);
    }

    //Consumer
    public static void processLowerBounded(List<? super Employee> employees){
        //employees.add(new Person("new Person")); //capture of ? super Employee
        employees.add(new Manager("New Manager"));
    }
}



package JavaCore.Generics.pecs3;

import java.util.ArrayList;
import java.util.List;

public class DemoPecs3 {
    public static void main(String[] args) {
        List<Manager> employees = new ArrayList<>();
        //employees.add(new Employee("Oleh", 70000));
        employees.add(new Manager("Alice", 70000));
        employees.add(new Developer("Bob", 80000));

        promoteEmployees(employees);
    }

    //Producer
    public static void promoteEmployees(List<? extends Manager> employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() > 50000) {  // Example condition for promotion
                System.out.println(employee.getName() + " is promoted!");
            }
        }
    }

    //Consumer
    public static void adjustSalary(List<? super Manager> employees) {

    }
}

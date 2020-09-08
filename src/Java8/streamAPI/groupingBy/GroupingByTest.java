package Java8.streamAPI.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * https://habr.com/ru/post/348536/
 * */

public class GroupingByTest {


    public static void main(String[] args) {

        List<Worker> workers = Arrays.asList(
                new Worker("Jim", 23, 400, "locksmith"),
                new Worker("Taylor", 32, 300, "engineer"),
                new Worker("Sonya", 19, 5000, "programmer"),
                new Worker("Jess", 26, 3200, "programmer"),
                new Worker("Kate", 19, 1500, "manager"),
                new Worker("Sonya", 44, 325, "engineer"),
                new Worker("Roy", 52, 5000, "manager"),
                new Worker("Stafani", 52, 5000, "programmer"),
                new Worker("Tom", 20, 3200, "programmer")
        );
        //1. Группировка списка рабочих по их должности (деление на списки)
        Map<String, List<Worker>> byPosition =
                workers.stream()
                        .collect(Collectors.groupingBy
                                (Worker::getPosition));

        //print(byPosition);

        //2. Группировка списка рабочих по их должности (деление на множества)
        Map<Integer, List<Worker>> byAge =
                workers.stream()
                        .collect(Collectors.groupingBy
                                (Worker::getAge));

        // print(byAge);


        //3. Подсчет количества рабочих, занимаемых конкретную должность

        Map<String, Long> workersOnPosition = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.counting()));

        System.out.println(workersOnPosition);

        //4. Группировка списка рабочих по их должности, при этом нас интересуют только имена

        Map<String, Set<String>> namesInPosition = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toSet())));

        //System.out.println(namesInPosition);

        //5. Расчет средней зарплаты для данной должности

        Map<String, Double> averageSalaryInPosition = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition,Collectors.averagingInt(Worker::getSalary)));

        //System.out.println(averageSalaryInPosition);

        //6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой

        Map<String, String> map6 = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.joining(", ", "{","}")))
                );

        //System.out.println(map6);

        //7. Группировка списка рабочих по их должности и по возрасту.

        Map<String, Map<Integer, List<Worker>>> collect = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.groupingBy(Worker::getAge)));

        //System.out.println(collect);

        Map<Character, Long> getCharacterFrequencyInFirstNames = workers.stream()
                    .map(Worker::getName)
                    .flatMapToInt(String::chars)
                    .mapToObj(c -> (char) c)
                    .collect(groupingBy(Function.identity(), counting()));

        Map<Character, Long> getCharacterFrequencyInFirstNamesAndPosition =
                workers.stream()
                .flatMap(c -> Stream.of(c.getName(), c.getPosition()))
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()));

    }

    public static void print(Map<?, List<Worker>> byGrParam){

        for(Map.Entry<?, List<Worker>> item : byGrParam.entrySet()){

            System.out.println(item.getKey());
            for(Worker worker : item.getValue()){

                System.out.println(worker.getName());
            }
            System.out.println();
        }


    }

}

class Worker{
    private String name;
    private int age;
    private int salary;
    private String position;

    public Worker(String name, int age, int salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}
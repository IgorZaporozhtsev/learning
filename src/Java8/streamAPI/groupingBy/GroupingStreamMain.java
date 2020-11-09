package Java8.streamAPI.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * https://habr.com/ru/post/348536/
 * */

public class GroupingStreamMain {

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
        groupByPosition(workers);

        //2. Группировка списка рабочих по их должности (деление на множества)
        byAge(workers);

        //3. Подсчет количества рабочих, занимаемых конкретную должность
        byPosition(workers);

        //4. Группировка списка рабочих по их должности, при этом нас интересуют только имена
        nameByPosition(workers);

        //5. Расчет средней зарплаты для данной должности
        salaryByPositionAverage(workers);

        //6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
        byPositionWithFirstName(workers);

        //7. Группировка списка рабочих по их должности и по возрасту.
        byAgeAndPosition(workers);

        getCharacterFrequencyInFirstNames(workers);

        getCharacterFrequencyInFirstNamesAndPosition(workers);
    }

    private static void byPositionWithFirstName(List<Worker> workers) {
        Map<String, String> positionWithFirstName = workers.stream()
            .collect(Collectors.groupingBy
                (Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.joining(", ", "{", "}")))
            );
    }

    private static void getCharacterFrequencyInFirstNamesAndPosition(List<Worker> workers) {
        Map<Character, Long> getCharacterFrequencyInFirstNamesAndPosition =
                workers.stream()
                .flatMap(c -> Stream.of(c.getName(), c.getPosition()))
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static void getCharacterFrequencyInFirstNames(List<Worker> workers) {
        Map<Character, Long> getCharacterFrequencyInFirstNames = workers.stream()
                    .map(Worker::getName)
                    .flatMapToInt(String::chars)
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static void byAgeAndPosition(List<Worker> workers) {
        Map<String, Map<Integer, List<Worker>>> collect = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.groupingBy(Worker::getAge)));
    }

    private static void salaryByPositionAverage(List<Worker> workers) {
        Map<String, Double> averageSalaryInPosition = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition,Collectors.averagingInt(Worker::getSalary)));
    }

    private static void nameByPosition(List<Worker> workers) {
        Map<String, Set<String>> namesInPosition = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toSet())));
    }

    private static void byPosition(List<Worker> workers) {
        Map<String, Long> workersOnPosition = workers.stream()
                .collect(Collectors.groupingBy
                        (Worker::getPosition, Collectors.counting()));
    }

    private static void byAge(List<Worker> workers) {
        Map<Integer, List<Worker>> byAge =
                workers.stream()
                        .collect(Collectors.groupingBy
                                (Worker::getAge));
    }

    private static void groupByPosition(List<Worker> workers) {
        Map<String, List<Worker>> byPosition =
                workers.stream()
                        .collect(Collectors.groupingBy
                                (Worker::getPosition));
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
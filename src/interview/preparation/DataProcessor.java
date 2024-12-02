package interview.preparation;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class DataProcessor {
    public static void main(String[] args) {
        Sensor sensor1 = new Sensor("movement", 1111, LocalDateTime.of(2024, 11, 16, 16, 24));
        Sensor sensor2 = new Sensor("movement", 1111, LocalDateTime.of(2024, 11, 16, 16, 25));
        Sensor sensor3 = new Sensor("movement", 2222, LocalDateTime.of(2024, 11, 16, 16, 26));
        Sensor sensor4 = new Sensor("movement", 1111, LocalDateTime.of(2024, 11, 16, 16, 27));
        Sensor sensor5 = new Sensor("movement", 2222, LocalDateTime.of(2024, 11, 16, 16, 28));
        Sensor sensor6 = new Sensor("movement", 3333, LocalDateTime.of(2024, 11, 16, 16, 29));
        Sensor sensor7 = new Sensor("movement", 11111, LocalDateTime.of(2024, 11, 16, 16, 30));

        Sensor sensor8 = new Sensor("temperature", 15, LocalDateTime.of(2024, 11, 16, 16, 24));
        Sensor sensor9 = new Sensor("temperature", 5, LocalDateTime.of(2024, 11, 16, 16, 25));
        Sensor sensor10 = new Sensor("temperature", 5, LocalDateTime.of(2024, 11, 16, 16, 26));
        Sensor sensor11 = new Sensor("temperature", 20, LocalDateTime.of(2024, 11, 16, 16, 27));
        Sensor sensor12 = new Sensor("temperature", 20, LocalDateTime.of(2024, 11, 16, 16, 28));
        Sensor sensor13 = new Sensor("temperature", 20, LocalDateTime.of(2024, 11, 16, 16, 29));
        Sensor sensor14 = new Sensor("temperature", 5, LocalDateTime.of(2024, 11, 16, 16, 30));

        Sensor sensor15 = new Sensor("pressure", 20, LocalDateTime.of(2024, 11, 16, 16, 24));
        Sensor sensor16 = new Sensor("pressure", 10, LocalDateTime.of(2024, 11, 16, 16, 25));
        Sensor sensor17 = new Sensor("pressure", 40, LocalDateTime.of(2024, 11, 16, 16, 26));
        Sensor sensor18 = new Sensor("pressure", 10, LocalDateTime.of(2024, 11, 16, 16, 27));
        Sensor sensor19 = new Sensor("pressure", 20, LocalDateTime.of(2024, 11, 16, 16, 28));
        Sensor sensor20 = new Sensor("pressure", 25, LocalDateTime.of(2024, 11, 16, 16, 29));
        Sensor sensor21 = new Sensor("pressure", 10, LocalDateTime.of(2024, 11, 16, 16, 30));

        List<Sensor> sensorList = List.of(
                sensor1,sensor2,sensor3,sensor4,sensor5,sensor6,sensor7,sensor8,sensor9,sensor10,
                sensor11,sensor12, sensor13, sensor14, sensor15, sensor16, sensor17, sensor18, sensor19, sensor20, sensor21);


        Map<LocalDateTime, List<Sensor>> groupByTimestamp = sensorList.stream()
                .collect(Collectors.groupingBy(sensor -> sensor.timestamp));


        double averageTemperature = sensorList.stream()
                .filter(sensor -> sensor.type.equals("temperature"))
                .mapToDouble(sens -> sens.value)
                .average()
                .orElseThrow();

        double totalMovementCount = sensorList.stream()
                .filter(sensor -> sensor.type.equals("movement"))
                .mapToDouble(sens -> sens.value)
                 .sum();

        double maxPressure = sensorList.stream()
                .filter(sensor -> sensor.type.equals("pressure"))
                .mapToDouble(sens -> sens.value)
                .max()
                .orElseThrow();




//        groupByTimestamp.forEach(
//                (k, v) -> {
//                    System.out.println(k);
//                    System.out.println(v);
//                }
//        );

        System.out.println(Math.round(totalMovementCount));

    }


}

class Sensor{
    public Sensor(String type, double value, LocalDateTime timestamp) {
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    String type;
    double value;
    LocalDateTime timestamp;

    @Override
    public String toString() {
        return "Sensor{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}
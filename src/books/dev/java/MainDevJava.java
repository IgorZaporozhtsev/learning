package books.dev.java;

import books.dev.java.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainDevJava {

    //https://dev.java/learn/creating-your-own-collector/


    public static void main(String[] args) {

        var vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car(Color.RED, Engine.HYBRID, Drive.WD2, 4));
        vehicles.add(new Truck(Engine.ELECTRIC, Drive.WD4, 1));




        List<Vehicle> electricVehicles = vehicles.stream()
                .collect(
                        Collectors.teeing(
                                Collectors.filtering(
                                        vehicle -> vehicle instanceof Car car && car.engine() == Engine.ELECTRIC,
                                        Collectors.toList()),
                                Collectors.filtering(
                                        vehicle -> vehicle instanceof Truck truck && truck.engine() == Engine.ELECTRIC,
                                        Collectors.toList()),
                                (cars, trucks) -> {
                                    cars.addAll(trucks);
                                    return cars;
                                }));

        System.out.println(electricVehicles.toString());
    }
}

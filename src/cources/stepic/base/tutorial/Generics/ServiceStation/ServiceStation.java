package cources.stepic.base.tutorial.Generics.ServiceStation;

public class ServiceStation {

    public static abstract class Vehicle {
        protected final String name;

        public Vehicle(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public static class Car extends Vehicle {
        public Car(String name) {
            super(name);
        }
    }

    public static class Motorcycle extends Vehicle {
        public Motorcycle(String name) {
            super(name);
        }
    }

    public static class Garage {

        private Vehicle vehicle;

        public Vehicle get() {
            return vehicle;
        }

        public void set(Vehicle vehicle) {
            this.vehicle = vehicle;
        }
    }

    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.set(new Car("Aston Martin"));
        Car car = (Car) garage.get();
        System.out.println(car.getName()); // Aston Martin

        Garage garage2 = new Garage();
        garage2.set(new Motorcycle("Honda CBR500R"));
        Motorcycle motorcycle = (Motorcycle) garage.get();
        System.out.println(motorcycle.getName());
    }
}

package design_patterns.patterns.creation.factory;

public class VehicleFactoryImplementation {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = VehicleFactory.getVehicle("car");
        System.out.println(car.getType());
        car.start();
        car.stop();
    }

}

class VehicleFactory{
    public static Vehicle getVehicle (String type){
        return switch (type) {
            case "car" ->  new Car();
            case "bike" ->  new Bike();
            default -> new Truck();
        };
    }
}

interface Vehicle{
    void start();
    void stop();
    String getType();
}

class Car implements Vehicle{

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public String getType() {
        return this.getClass().getTypeName();
    }
}

class Bike implements Vehicle{

    @Override
    public void start() {
        System.out.println("Bike started");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped");

    }

    @Override
    public String getType() {
        return this.getClass().getTypeName();
    }
}

class Truck implements Vehicle{

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public String getType() {
        return "";
    }
}


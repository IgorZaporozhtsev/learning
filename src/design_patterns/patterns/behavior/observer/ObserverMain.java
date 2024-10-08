package design_patterns.patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

interface Observed {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void setMeasurements(int t, int p);
}

interface Observer {
    void handleEvent(int temp, int presser);
}

public class ObserverMain {
    public static void main(String[] args) {
        Observed meteoStation = new ClimateControlSystem();
        meteoStation.addObserver(new AirFresherObserver());
        meteoStation.addObserver(new HeatingSystemObserver());
        meteoStation.setMeasurements(43, 200);
    }
}


class ClimateControlSystem implements Observed {
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>(); //listeners

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(temperature, pressure);
        }
    }

    public void setMeasurements(int t, int p) {
        this.temperature = t;
        this.pressure = p;
        notifyObservers();
    }
}

//Listener
class HeatingSystemObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println( this.getClass().getSimpleName() + " Погода изменилася. Температура = " + temp + ", Давление = " + presser);
        if(temp > 10){
            System.out.println("decreasing temperature - 10 C");
        } else {
            System.out.println("increasing temperature + 10 C");
        }
    }
}

//Listener
class AirFresherObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println( this.getClass().getSimpleName() + " Погода изменилася. Температура = " + temp + ", Давление = " + presser);
        if(temp > 10){
            System.out.println("start freshening air");
        }
    }
}



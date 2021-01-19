package design_patterns.observer;

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
        Observed meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.setMeasurements(23, 200);
    }
}

class MeteoStation implements Observed {
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

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

class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Погода изменилася. Температура = " + temp + ", Давление = " + presser);
    }
}




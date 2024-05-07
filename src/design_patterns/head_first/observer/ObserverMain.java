package design_patterns.head_first.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ThirdPartyDisplay thirdPartyDisplay = new ThirdPartyDisplay(weatherData);
        currentConditionsDisplay.display();
        thirdPartyDisplay.display();
        weatherData.setMeasurement(20.0f, 12.0f, 33.0f);

    }
}


interface Subject{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer{
    void update();
}

interface DisplayElement{
    void display();
}

class WeatherData implements Subject{

    private final List<Observer> observers; // Subject hold observers
    float temperature;
    float humidity;
    float pressure;

    WeatherData() { //init list for Observers
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
        //trigger all Observer in thr list to notify each Observer that data has been changed (through setMeasurement)
        //by calling update method for each one
        //then each Observer in update method can getter data from WeatherData what its need
    }

    private void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurement(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

class CurrentConditionsDisplay implements Observer, DisplayElement{
    float temperature;
    float humidity;
    float pressure;
    private final WeatherData weatherData; //Observer has the link to Subject so can use getter to retrive data

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay temperature: "+ temperature +", "+ "humidity: "+ humidity +", "+ "pressure: "+ pressure);
    }

    @Override
    public void update() {
        //we get data what we need
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.pressure;
        display();
    }
}

class ThirdPartyDisplay implements Observer, DisplayElement{
    float temperature; // in this Observer we need only display
    private WeatherData weatherData;

    public ThirdPartyDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("ThirdPartyDisplay temperature: "+ temperature);

    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        display();
    }
}


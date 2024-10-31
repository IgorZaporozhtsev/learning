package design_patterns.patterns.behavior.state;

import JavaCore.collection.stack.Stack;

public class StateVVDemo {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        radio.play();
        radio.nextStation();
        radio.play();
        radio.play();
        radio.nextStation();
        radio.play();
    }
}

interface Station{
    void play();
}

class Radio7 implements Station{

    @Override
    public void play() {
        System.out.println("Radio7 is playing ....");
    }
}

class HitFM implements Station{

    @Override
    public void play() {
        System.out.println("HitFM is playing ....");
    }
}

//Context
class Radio{
    Station station;

    void setStation(Station station){
        this.station = station;
    }

    void nextStation(){
        if(station instanceof Radio7){
            setStation(new HitFM());
        }
        else if (station instanceof HitFM){
            setStation(new Radio7());
        }
    }

    void play(){
        station.play();
    }
}

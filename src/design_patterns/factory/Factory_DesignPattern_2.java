package design_patterns.factory;

public class Factory_DesignPattern_2 {
    public static void main(String[] args) {
        WatchMaker watchMaker = new ConcreteDigitalWatch();
        Watch watch = watchMaker.createWatch();
        watch.showTime();
        // этот код не будет меняться если мы поменяем на  new ConcreteAnalogWatch();
    }
}

interface WatchMaker{
    Watch createWatch();
}

class ConcreteDigitalWatch implements WatchMaker{
    Watch watch;

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("Show DigitalWatch");
    }
}

class AnalogWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("Show AnalogWatch");
    }
}


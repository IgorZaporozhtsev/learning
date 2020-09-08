package cources.stepic.base.tutorial.Lambda.LampaExemple;

public class Lamp implements ElectricityConsumer {

    public void lighrtOn() {
        System.out.println("Лампа зажглась");
    }

    @Override
    public void electricityOn(Object sender) {
        lighrtOn();
    }
}

package cources.stepic.base.tutorial.Lambda.LampaExemple;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    // хранит множество ссылок на потребителя
    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Выключатель включен");

        for (ElectricityConsumer c : listeners) {
            c.electricityOn(this);
        }
    }
}

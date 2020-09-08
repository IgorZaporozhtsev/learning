package cources.stepic.base.tutorial.Lambda.LampaExemple;

public class Program {
    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);
        sw.switchOn();


//-----------------------------------------------------------------------------------------------------------

/*Для создания единоразовго действий для слушателей (Радио и Лампа )
* типа метода "Пожар" мы могли создать:
*  - полноценный класс или
 *  - анонимный класс или
  *  -ЛЯМДА выражение*/


/* Пример использование анонимного класса

*  Мы создаем как бы класс ElectricityConsumer анонимно интерфеса ElectricityConsumer
*  создаем его обьект new ElectricityConsumer а дальше метод
* */
        sw.addElectricityListener(
                new ElectricityConsumer() {
                    public void electricityOn(Object sender) {
                        System.out.println("Пожар");
                    }
                }
        );

  /*Пример Лямбда выражения */
        sw.addElectricityListener((sender) -> System.out.println("Пожар2"));
        sw.switchOn();

//----------------------------------------------------------------------------------------------------

/* Два идентичных вызова
*  Сигнатура метода fire у нас такая же как у метода
*  electricityOn(Object sender) интерфейса ElectricityConsumer
*  тоесть набор типов параметоров такой же
*  тоесть s -> вызывает метод fire(s) ттакими же параметрами
*  поэтому можно использовать 2-е выражение
*
* */

      /*1. */
        sw.addElectricityListener(s -> Program.fire(s));
     /* 2. */
        sw.addElectricityListener(Program::fire);
        sw.switchOn();
    }


    // метод для примера для выражения (WildCard::fire)

    public static void fire(Object sender) {
        System.out.println("Lambda with ::");
    }
}

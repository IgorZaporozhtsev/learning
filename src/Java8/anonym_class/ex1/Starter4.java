package Java8.anonym_class.ex1;

public class Starter4 {

    //переменные должны быть эффективно финальны
    //чтоб переменная была ввида а анонимном классе
    public static void main(String[] args) {
        String text = "some text"; //переменная должна быть effective final тоесть не изменяемая дальше в коде
        // но лучше просто сделать переменую final чтоб самомму не следить финальная или нет  final String text = "some text";
        //text = "another text" если раскоментированть то переменная не будет видна в анонимном классе. Потому что мы ее изменили
        final IPrinter textPrinter = new IPrinter(){

            @Override
            public void printText() {
                System.out.println(text);
            }
        };

        textPrinter.printText();
    }
}

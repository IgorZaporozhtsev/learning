package Java8.anonym_class.ex1;

public class Starter2 {
    public static void main(String[] args) {

        //если стоят фигурные скобки после создания экземпляра класса, это значит что создаеться новый анонимный класс
        // который extend TextPrinter и в фигурных скобках можно переопределять его методы

        final IPrinter textPrinter = new TextPrinter("Text to print"){ //IPrinter textPrinter = new IPrinter(){}

            @Override
            public void printText() {
                System.out.println("***************");
                super.printText();
            }
        };

        textPrinter.printText();

        IPrinter iPrinter = () -> System.out.println("printed");
        iPrinter.printText();

    }
}

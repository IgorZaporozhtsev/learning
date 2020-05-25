package Java8.anonym_class.ex1;

public class TextPrinter implements IPrinter {
    String text;

    public TextPrinter(String text) {
        this.text = text;
    }

    @Override
    public void printText() {
        System.out.println("Print text in class TextPrinter");
    }
}

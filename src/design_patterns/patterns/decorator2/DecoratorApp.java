package design_patterns.patterns.decorator2;
//Open Close Principle
public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface oldBehavior = new Printer("print Привет");
        PrinterInterface newBehaviorWithQuotes = new QuotesDecorator(new Printer("print with quotes Привет"));
        oldBehavior.print();
        newBehaviorWithQuotes.print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}


class QuotesDecorator implements PrinterInterface {
    PrinterInterface component;

    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.print("\""); //add additional logic
        component.print();
        System.out.print("\""); //add additional logic
    }
}
package design_patterns.decorator2;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printerInterface = new Printer("Привет");
        printerInterface.print();
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
        System.out.println(value);
    }
}


class QuotesDecarator implements PrinterInterface{
    PrinterInterface component;

    public QuotesDecarator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}
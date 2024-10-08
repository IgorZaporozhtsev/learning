package design_patterns.patterns.structural.decorator2;
//Open Close Principle
public class DecoratorInherit {
    public static void main(String[] args) {
        PrinterInterface oldBehavior = new Printer("print Привет");
        PrinterInterface newBehaviorWithQuotes = new QuotesDecoratorChild(new PrinterA("print with quotes Привет"));
        oldBehavior.print();
        newBehaviorWithQuotes.print();
    }
}


class PrinterA implements PrinterInterface{
    String value;

    public PrinterA(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        //so something
        System.out.print(value);
    }
}

class ForwardingPrinter implements PrinterInterface{

    private final PrinterInterface printerInterface;

    ForwardingPrinter(PrinterInterface printerInterface) {
        this.printerInterface = printerInterface;
    }

    @Override
    public void print() {
        printerInterface.print();
    }
}


class QuotesDecoratorChild extends ForwardingPrinter {

    public QuotesDecoratorChild(PrinterInterface printerInterface) {
        super(printerInterface);
    }

    @Override
    public void print() {
        System.out.println();
        System.out.print("\""); //add additional logic
        super.print();
        System.out.print("\""); //add additional logic
    }
}
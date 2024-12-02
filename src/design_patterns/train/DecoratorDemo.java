package design_patterns.train;

public class DecoratorDemo {
    public static void main(String[] args) {
//        Coffee coffee = new Espresso(); // Base coffee
//        coffee = new Milk(coffee);     // Add milk
//        coffee = new Mocha(coffee);    // Add mocha
//        coffee = new WhippedCream(coffee); // Add whipped cream

        Coffee coffee  = new WhippedCream(new Milk(new Mocha(new Espresso())));

        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());
    }
}


interface Coffee{
    double getCost();
    String getDescription();
}


class Espresso implements Coffee{

    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}

class Milk extends CoffeeDecorator{

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class Mocha extends CoffeeDecorator{

    public Mocha(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mocha";
    }
}

class WhippedCream extends CoffeeDecorator{

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipped Cream";
    }
}

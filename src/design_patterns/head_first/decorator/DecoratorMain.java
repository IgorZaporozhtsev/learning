package design_patterns.head_first.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        //Its behave like linked list that bind different decorators

        //1-st approach
        Beverage darkRoast = new DarkRoast(Size.TALL);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Soy(darkRoast);
        darkRoast = new Whip(darkRoast);

        //2-nd approach
//        Beverage darkRoast = new Whip(new Soy(new Mocha(new DarkRoast(Size.TALL))));

        double beverageCost = darkRoast.cost();
        String description = darkRoast.getDescription();
        System.out.println(beverageCost);
        System.out.println(description);
    }
}


abstract class Beverage {
    String description = "Unknown Beverage";
    Size size = Size.DEFAULT;

    public String getDescription() {
        return description;
    }

    public Size getSize(){
        return size;
    }
    public abstract double cost();
}

class DarkRoast extends Beverage {

    public DarkRoast(Size size) {
        super.size = size;
        description = "DarkRoast";
    }
    @Override
    public double cost() {
        return 2.00;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return 0.89;
    }

    @Override
    public Size getSize() {
        return Size.GRANDE;
    }
}


abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
    public abstract Size getSize();
}

class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }


    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}

class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";

    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        if(beverage.getSize() == Size.TALL){
            return beverage.cost() + 0.10;
        } else if (beverage.getSize() == Size.GRANDE){
            return beverage.cost() + 0.15;
        } else if (beverage.getSize() == Size.VENTI) {
            return beverage.cost() + 0.20;
        }
        return beverage.cost() + 0.05;
    }
}

class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}


enum Size{
    TALL, GRANDE, VENTI, DEFAULT
}

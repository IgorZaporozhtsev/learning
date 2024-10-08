package design_patterns.patterns.creation.builder;

public class Builder_DesignPattern_2 {

    public static void main(String[] args) {
        DayBuilder dayBuilder1 = new DayBuilder();
        dayBuilder1.setHotel("Hilton");
        dayBuilder1.setCost(1000);
        dayBuilder1.setNumberOfNutrition(5);
        dayBuilder1.setSpecialOffer("cycling");

        DayBuilder dayBuilder2 = new DayBuilder();
        dayBuilder2.setHotel("Grant Hotel");
        dayBuilder2.setCost(1500);
        dayBuilder2.setNumberOfNutrition(5);
        dayBuilder2.setSpecialOffer("Safari");

        Day day_1 = dayBuilder1.getDay();
        Day day_2 = dayBuilder2.getDay();

        System.out.println(day_1);
        System.out.println(day_2);
    }
}

interface Offers{
    void setHotel(String name);
    void setCost(int value);
    void setNumberOfNutrition(int count);
    void setSpecialOffer(String offerName);
}

class DayBuilder implements Offers{

    String name;
    int value;
    int count;
    String offerName;

    @Override
    public void setHotel(String name) {
        this.name = name;
    }

    @Override
    public void setCost(int value) {
        this.value = value;
    }

    @Override
    public void setNumberOfNutrition(int count) {
        this.count = count;
    }

    @Override
    public void setSpecialOffer(String offerName) {
        this.offerName = offerName;
    }

    public Day getDay() {
        return new Day(name, value, count, offerName);
    }

}

class Day {
    String name;
    int value;
    int count;
    String offerName;

    public Day(String name, int value, int count, String offerName) {
        this.name = name;
        this.value = value;
        this.count = count;
        this.offerName = offerName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Day{" +
            "name='" + name + '\'' +
            ", value=" + value +
            ", count=" + count +
            ", offerName='" + offerName + '\'' +
            '}';
    }
}

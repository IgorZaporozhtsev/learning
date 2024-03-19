package JavaCore.enums;

public class Main1 {
    public static void main(String[] args) {
        var subscription = new Subscription();
        subscription.isActive = true;

        var active1 = Subscription.State.valueOf("ACTIVE");

        var active2 = Subscription.State.ACTIVE;

        System.out.println(active1.equals(active2));


        var x = Subscription.State.ACTIVE.toString();
        x = "";
        System.out.println(x);
    }


}

//Проблема в тому коли нам треба мати декілька різних станів
//boolean добре коли 2 значення
class Subscription {
    String name;
    String description;
    boolean isActive;

    State state;

    enum State{
        NONE, ACTIVE, SUSPENDED
    }
}

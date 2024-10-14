package design_patterns.patterns.behavior.state;

public class StateDemo {
    public static void main(String[] args) {
        Activity sleeping = new Sleeping();
        Developer developer = new Developer();
        developer.setActivity(sleeping);

        for (int i = 0; i < 10; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}

interface Activity{
    void justDoit();
}

class Sleeping implements Activity{

    @Override
    public void justDoit() {
        System.out.println("I'm sleeping");
    }
}

class Coding implements Activity{

    @Override
    public void justDoit() {
        System.out.println("I'm coding");
    }
}

class Developer{
    Activity activity;

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public void changeActivity(){
        if(activity instanceof Sleeping){
            setActivity(new Coding());
        } else if (activity instanceof Coding) {
            setActivity(new Sleeping());
        }
    }

    public void justDoIt(){
        activity.justDoit();
    }
}
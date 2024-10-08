package design_patterns.patterns.behavior.strategy;

public class StrategyDeveloperRunner {

  public static void main(String[] args) {
    Developer developer = new Developer();
    developer.setActivity(new Codding());
    developer.invokeActivity();
  }
}


class Developer{

  Activity activity;

  public void setActivity(Activity activity){
    this.activity = activity;
  }

  public void invokeActivity(){
    activity.justDoIt();
  }

}

interface Activity{
  void justDoIt();
}

class Codding implements Activity{
  @Override
  public void justDoIt() {
    System.out.println("Developer is codding");
  }
}

class Sleeping implements Activity{
  @Override
  public void justDoIt() {
    System.out.println("Developer is sleeping");
  }
}



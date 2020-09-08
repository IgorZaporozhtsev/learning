package books.Schildt.core;

public class StaticMethodExplainer extends BaseExplainStaticMethod{


    public StaticMethodExplainer(String street) {
        super();
        this.street = street;
    }

    private String street;

    public static void fooStatic(String street){

        System.out.println("I am static");
        //this.street = street; //cannot be referenced form a static context
        //super.fooNoStatic(street); //cannot be referenced form a static context
    }

    public void fooNoStatic(String street){
        super.fooNoStatic(street);

        System.out.println("I am NOT static");
        this.street = street;
    }

}

class BaseExplainStaticMethod{

    public void fooNoStatic(String street){
    }
}

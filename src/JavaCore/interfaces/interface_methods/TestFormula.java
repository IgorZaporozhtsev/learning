package JavaCore.interfaces.interface_methods;

public class TestFormula implements Formula{

    public static void main(String[] args) {

        Formula formula = new TestFormula();

        Formula.staticMethod(8);                      //static method
        System.out.println(formula.defaultSqrtMethod(16));       //default method
        System.out.println(formula.calculate(32));  //standard method
    }

    @Override
    public int calculate(int a) {
        return  a + 8;
    }

    
}

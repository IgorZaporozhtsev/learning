package MyExemples.draft;

public class FunctionalPointersMain {


}

class Pointer {

    interface FunctionPointer {
        // Method signatures of pointed method
        void methodSignature(int a);
    }

    public void method1(int b) {
        System.out.println("Called method1 with integer " + b);
    }

    public void method2(int v) {
        System.out.println("Called method2 with integer " + v);
    }

    public void method3(int a) {
        System.out.println("Called method3 with integer " + a);
    }

    public void foo() {
        FunctionPointer pointer1 = this::method1;
        FunctionPointer pointer2 = this::method2;

        // Call both methods using their "pointer"
        pointer1.methodSignature(3);
        pointer2.methodSignature(2);

        // Reassign and call pointer 1
        pointer1 = this::method3;

        pointer1.methodSignature(5);

    }

}



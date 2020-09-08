package books.Schildt.core;

public class DynamicMethod {
    public static void main(String args []) {
        A a = new A();
        B b = new B();
        C c = new C();

        A r;

        r=a;
        r.callme();

        r=b;
        r.callme();

        r=c;
        r.callme();

        System.out.println(" -----------  or  ------------- ");

        //or


        A a1 = new A();
        a1.callme();

        a1 = new B();
        a1.callme();

        a1 = new C();
        a1.callme();

        System.out.println(" -----------  or  ------------- ");

        //or

        A a2 = new A();
        a2.callme();

        A a3 = new B();
        a3.callme();

        A a4 = new C();
        a4.callme();



    }
}

class A {
    void callme() {
        System.out.println("   callme() из класса А");
    }
}

class B extends A {
    void callme() {
        System.out.println("   callme() из класса B");
    }
}

class C extends A {
    void callme() {
        System.out.println("   callme() из класса C");
    }
}


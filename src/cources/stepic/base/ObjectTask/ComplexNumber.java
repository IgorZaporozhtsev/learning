package cources.stepic.base.ObjectTask;
        /*Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals()
        сравнивал экземпляры ComplexNumber по содержимому полей re и im, а hashCode()
        был бы согласованным с реализацией equals().*/

import java.util.HashMap;
import java.util.HashSet;

public class ComplexNumber {

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(0, 1);
       Object b = new ComplexNumber(0, 1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == (b.hashCode()));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


    }


    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }


    @Override
    public boolean equals (Object obj){ //в каки х случаях равны (перечисляем)
        if (this == obj) { // должный быть равны ссылки
            return true;
        }

        if (obj == null){ // обьект должен быть не null
            return false;
        }
        if (getClass() != obj.getClass()){ //класс который передаеться должен быть равен классу Object
            return false;
        }

        ComplexNumber complex = (ComplexNumber) obj;              //поля должны быть одинаковые
        if (this.re == complex.re && this.im == complex.im){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode () {

        return (int) (111*87*re*im);
    }

// ComplexNumbe a = new ComplexNumbe();
// ComplexNumbe b = new ComplexNumbe();
    //System.out.println(a == a);

    //System.out.println(a == b);




}

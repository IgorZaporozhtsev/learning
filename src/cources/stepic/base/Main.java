package cources.stepic.base;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int a = 0, b = 0,  c = 0;
        Random r = new Random();

        for (int i = 0; i < 10 ; i++) {
            try {
                b = r.nextInt();
                c = r.nextInt();
                int z = 0;
                z = b /c;
                System.out.println("Число z: " + z);
                a = 12345 / z;
            }
            catch (ArithmeticException e){
                System.out.println("Деление на 0");
                a = 0; //присвоить 0 и продолжать работу
            }

            System.out.println("a: " + a);        }

    }


}

package cources.stepic.base.tutorial.ExeptionsTutorial;


import java.util.Arrays;

public class ExepTut {


    public static void main(String[] args) {
        int nums[] = new int[4];

        try{
            nums [7]  = 10;
            System.out.println("Ошибки в массиве нет");
        }

        // Перехват исключения в связи с выходом за пределы массива

        catch (ArrayIndexOutOfBoundsException arr){
            System.out.println("Вышли за пределы массива");
        }

        System.out.println(Arrays.toString(nums));
        System.out.println("//===========================================================================");

//===========================================================================

//Исключение которое сгенерировано одним методом а перехваченно другим

        try {
            ExcTest.genException() ;
        }
//А здесь исключение перехватывается.
        catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Вышли за пределы индекса!");
        }
        System.out.println("После перехвата");
    }


static class ExcTest {
    // сгенерировать исключение
     static void genException()	{
        int nums[] = new int[4];
        System.out.println("Before exception is generated.");
// Здесь генерируется исключение в связи с
// обращением за границы массива.
        nums[7] = 10;
        System.out.println("this won't be displayed");
    }
}




}

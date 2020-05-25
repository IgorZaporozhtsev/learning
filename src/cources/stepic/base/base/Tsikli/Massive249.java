package cources.stepic.base.base.Tsikli;

/*Реализуйте метод, сливающий два отсортированных по неубыванию массива
чисел в один отсортированный в том же порядке массив.
Массивы могут быть любой длины, в том числе нулевой.*/


import java.util.Arrays;

public class Massive249 {

    public static void main(String[] args) {
        int [] a1 =  {1, 3, 5};
        int [] a2 =  {2, 4, 6, 17, 18};
        mergeArrays(a1, a2);
    }

    // мы должны задавать в параметрах метода уже отсортированые массивы!

    public static int[] mergeArrays(int[] a1, int[] a2) {

        int i = 0; int j = 0;  int k = 0;
        int[] c = new int[a1.length + a2.length];

        while (k < c.length) {

            if (a1.length <= i) {
                c[k] = a2[j]; j++;
            }

            else if (a2.length <= j) {
                c[k] = a2[i]; i++;

            } else {


                if (a1[i] <= a2[j]){
                    c[k] = a1[i];
                    i++;

                } else {

                    c[k] = a2[j];
                    j++;
                }
            }

            k++;
        }


        System.out.println(Arrays.toString(c));

        return c;
    }
}

package cources.stepic.base.base.primitive;




/*В Григорианском календаре год является високосным в двух случаях:
либо он кратен 4, но при этом не кратен 100, либо кратен 400.

Реализуйте метод, вычисляющий количество високосных
лет с начала нашей эры (первого года) до заданного года включительно.*/


public class Gregorian218 {
    public static void main(String[] args) {
        System.out.println(leapYearCount(2000));
    }


    public static int leapYearCount(int year) {

        int visokos = year/4 - year/100 + year/400;
        return visokos;
    }


}

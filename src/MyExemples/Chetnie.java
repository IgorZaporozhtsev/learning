package MyExemples;

//	Написать программу, выводящую на экран только четные целые числа из диапазона от 1 до 100.

public class Chetnie {
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {

            if (i%2 == 0){       //Если остаток деления на 2 равен 0 значит вывести на экран i
                System.out.print(i);
            }



        }
    }
}

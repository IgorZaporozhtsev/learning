package cources.stepic.base.base.casting;

/*Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки*/


public class PowerTwo229 {
    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(8));

    }


        public static boolean isPowerOfTwo(int value) {

            int bitCount = Integer.bitCount(Math.abs(value));

            // Integer.bitCount() - возвращает кол-во еденичных бит в числе
            //тоесть еденичек в числе
            //т.к у числа в степени 2 количество еденичных бит вседа == 1
            // то возвращаем bitCount == 1


            return bitCount == 1;
        }


}

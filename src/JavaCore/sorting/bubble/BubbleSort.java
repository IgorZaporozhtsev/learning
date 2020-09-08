package JavaCore.sorting.bubble;

public class BubbleSort { //https://www.youtube.com/watch?v=RqfWvIsYmsc
    public static void main(String[] args) {
        //This initialises an array of five integers
        int[] houseNumbers = {5,4,1,2,3};

        //Let's print these out to show that there is no cheating
        System.out.println("The original sequence:  ");
        for (int i = 0; i < houseNumbers.length; i++) {
            System.out.print(houseNumbers[i] + ", ");
        }

        System.out.println("\n");

        //Now, let's sort these numbers using a bubble sort
        SortEm(houseNumbers);
    }

    private static void SortEm(int[] array) {
// We need a temporary (временный) storage area for when we wnt to swap numbers
    int temp;

    //This is the code that dose the bubble sort
        for (int i = array.length - 1; i > 0; i--) { //идем по индексам от 4 до 0. Количество проходов зависит от количества не отсортировниых чисел в массиве
            for (int j = 0; j < i; j++) {            // В этой инерации сравниваем между собой рядом стоящие числа
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        //Finally, let's print out the sorted version of array
        System.out.println("The new sequence:-    ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ ", ");
        }
        System.out.println();
    }


}

package JavaCore.sorting.bubble;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = {19,3,-44,9};
        int[] mas = bubbleSort(array);
        for (int i = 0; i < mas.length ; i++) {
            System.out.println(mas[i]);
        }

    }

    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted  = array.length - 1;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]){
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }

        return array;
    }

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

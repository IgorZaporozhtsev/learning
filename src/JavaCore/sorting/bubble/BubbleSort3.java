package JavaCore.sorting.bubble;

public class BubbleSort3 {
    public static void main(String[] args) {
        int[] mas = new int[10];

        //Input data
        for (int i = 0; i < mas.length ; i++) {
            mas[i] = (int) (Math.random()*100);
            System.out.print(mas[i] + " ");
        }

        Sorter sorter = new Sorter(mas);
        mas = sorter.bubbleSort();


        //Output data
        System.out.println();
        for (int i = 0; i < mas.length ; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}

package algoexpert.arrays;

import java.util.Arrays;

public class NonConstructiveChange {

    public static void main(String[] args) {
        int i = nonConstructiveChange(new int[]{1,2,5,7});
        //int i = nonConstructiveChange(new int[]{1, 2 ,5});
        //1,2,4,5,6
        //не могу дать сдачи 3 coins учитівая кобинации монет
        System.out.println(i);
    }

    public static int nonConstructiveChange(int[] coins) {
        if(coins.length == 0){
            return 1;
        }
        Arrays.sort(coins);
        // [ 1, 1, 2, 3, 5, 7, 22 ]

        int change = 0;

        for (int coin : coins) {
            if (change + 1 < coin) {
                break;
            }
            change = change + coin;
        }


        return change + 1;
    }
}

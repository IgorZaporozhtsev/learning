package algoexpert.arrays;

public class NonConstructiveChange {

    public static void main(String[] args) {
        int i = nonConstructiveChange(new int[]{4, 1, 1});
        //1,2,4,5,6
        //не могу дать сдачи 3 coins учитівая кобинации монет
        System.out.println(i);
    }

    public static int nonConstructiveChange(int[] coins) {
        // Write your code here.
        int arrSum = 0;

        int coin1 = coins[0];
        int coin2 = coins[1];
        int coin3 = coins[2];
        int coin4 = coins[0] + coins[1];
        int coin5 = coins[1] + coins[2];
        int coin6 = coin4 + coin3;

        //если у нас пропуск сразу возвращаю пепвій прпустк
        //товар должен стоить 3

        for (int i = 0; i < coins.length; i++) {
            arrSum =+ coins[i];
        }
        return arrSum;
    }
}

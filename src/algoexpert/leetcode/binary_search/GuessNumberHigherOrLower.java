package algoexpert.leetcode.binary_search;

public class GuessNumberHigherOrLower {
    //374. Guess Number Higher or Lower
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
            int l = 1;
            int r = n;
            while (l <= r){
                int m =  l + (r - l) / 2;
                int res = 0; //guess(m);
                if (res > 0){
                    l = m + 1;
                } else if (res < 0){
                    r = m - 1;
                }else if (res == 0){
                    return m;
                }
            }
            return -1;

    }
}

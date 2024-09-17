package algoexpert.leetcode.two_pointers;

import java.util.Arrays;

public class AssignCookies_455 {
    //455. AssignCookies
    //https://leetcode.com/problems/assign-cookies/description/
    //Array
    //Two Pointers
    //Greedy
    //Sorting

    public static void main(String[] args) {
        //int[] g = {1,2};
        //int[] s = {1,2,3};
        //int[] g = {1,2,3};
        //int[] s = {1,1};
        //int[] g = {1,2,3};
        //int[] s = {0,0,1,2,3};
        int[] g = {0,0,1,2,3};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length) {
            while (j < s.length && g[i] > s[j]){
                j++;
            }
            if (j < s.length){
                i++;
                j++;
            } else {
                break;
            }
        }
        return i;
    }
}

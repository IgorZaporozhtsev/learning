package cources.stepic.base.tutorial.Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
        MyRunner r = new MyRunner();
        new Thread(r).start();

       String [] strings = {"One", "Two", "Free"};
       Arrays.sort(strings, new LengthStringComparator());

        for (String s:strings) {
            System.out.println(s);
        }


    }

    static class MyRunner implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++)
                doWork();
        }

        public void doWork(){

        }
    }

    static class LengthStringComparator implements Comparator<String> {

        public int compare(String firstStr, String secondStr) {
            return Integer.compare(firstStr.length(),secondStr.length());
        }



    }




}

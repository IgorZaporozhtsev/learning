package cources.stepic.base.GCS;

import java.util.*;

public class DequecCol {
    public static void main(String[] args) {

        ArrayList <Integer> list1 = new ArrayList <Integer>();
            Scanner scanner = new Scanner(System.in);

            int count = 0;
            while (scanner.hasNextInt()) {
                if (count %2 == 0){
                    scanner.nextInt();
                    count++;
                }
                else {
                    list1.add(scanner.nextInt());

                    count++;

                }

        }

        Iterator<Integer> iterator = list1.iterator();
        Collections.reverse(list1);
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" ");
        }


    }
}


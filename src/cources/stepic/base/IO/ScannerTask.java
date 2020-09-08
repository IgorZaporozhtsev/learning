package cources.stepic.base.IO;
import java.util.Scanner;

public class ScannerTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()){
        sum = sum + Double.parseDouble(scanner.next());
        }
        System.out.format("%.6f", sum);


    }
}

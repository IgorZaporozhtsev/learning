package algoexpert.codewars;

import java.util.ArrayList;
import java.util.List;

public class PrinterErrors {

    /*

    s="aaabbbbhaijjjm"
    printer_error(s) => "0/14"

    s="aaaxbbbbyyhwawiwjjjwwm"
    printer_error(s) => "8/22"

    * */
    public static void main(String[] args) {
        //String s = printerError("aaaxbbbbyyhwawiwjjjwwm");
        String s = printerError("aaabbbbhaijjjm");
        System.out.println(s);
    }

    public static String printerError(String s) {
        List<Character> acceptableChars = new ArrayList<>();
        acceptableChars.add('a');
        acceptableChars.add('b');
        acceptableChars.add('c');
        acceptableChars.add('d');
        acceptableChars.add('e');
        acceptableChars.add('f');
        acceptableChars.add('g');
        acceptableChars.add('h');
        acceptableChars.add('i');
        acceptableChars.add('j');
        acceptableChars.add('k');
        acceptableChars.add('l');
        acceptableChars.add('m');


        char[] charArray = s.toCharArray();
        int error_counter = 0;

        for (int j = 0; j < charArray.length; j++) {
            for (int i = 0; i < acceptableChars.size(); i++) {
                if (acceptableChars.get(i) == charArray[j]){
                  break;
                } else if (acceptableChars.size() - 1 == i){
                    error_counter++;
                }
            }
        }
        return error_counter + "/"+ s.length();
    }
}

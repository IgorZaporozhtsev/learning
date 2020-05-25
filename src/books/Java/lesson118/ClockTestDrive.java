package books.Java.lesson118;

/**
 * Created by Igor on 22.12.2016.
 */
public class ClockTestDrive {
    public static void main(String[] args) {
         Clock c = new Clock();

         c.setTime("12345");


        String tod = c.getTime();

        System.out.println("время: " + tod);
    }
}

package books.Java.lesson118;


public class Xcopy {

    public static void main(String[] args) {
        int orig = 42;
        Xcopy x = new Xcopy();

        int y = x.go(orig);

        System.out.println(orig + " " + y);


    }

    int go(int arg){
    arg = arg * 2;
        return arg;
    }

}

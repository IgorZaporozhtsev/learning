package books.Schildt.core;

public class RecursionTest {
//    int [] values;
//
//    public RecTest(int i) {
//        this.values = new int[i];
//    }


    void printArray(int i){
        if (i == 0){
            return;
        }
        else {
            printArray(i - 1);
        }
        System.out.println("[" +  (i - 1) + "]" );
    }

}

class Recursion2{

    public static void main(String[] args) {
        //RecTest ob = new RecTest(10) ;
        RecursionTest ob = new RecursionTest() ;

//        for (int i= 0; i < 10 ; i ++ ) {
//            ob.values [i]  = i;
//        }
//
        ob.printArray(10);


    }
}

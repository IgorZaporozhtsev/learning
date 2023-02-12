package JavaCore.recursion;

public class RecursionExample {

    public static void main(String[] args) {
        counter(5);
    }

    // --- Recursion Stack --- LIFO
    //  | counter(5) |
    //  | counter(4) |
    //  | counter(3) |
    //  | counter(2) |
    //  | counter(1) |

    private static void counter(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        counter(n - 1);
    }
}

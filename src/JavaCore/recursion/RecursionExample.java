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

    private static int counter(int n) {
        if (n == 0) {
            return n;
        }
        System.out.println(n);
        return counter(n - 1);
    }
}

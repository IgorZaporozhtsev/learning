package algoexpert.codewars;

public class DemoPerfectSq {
    public static void main(String[] args) {
        //System.out.println(findNextSquare(114));


        String s1 = "hello";
        String s2 = new String("hello");
        int hashCode1 = s1.hashCode();
        int hashCode2 = s2.hashCode();

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(hashCode1 + " " + hashCode2);
        System.out.println(hashCode1 == hashCode2);

    }
    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if (sq % sqrt != 0) {
            return -1;
        }
        return (long) Math.pow(sqrt + 1, 2);
    }
}





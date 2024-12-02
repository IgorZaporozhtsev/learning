package algoexpert.codewars;

public class StringEndsWith {
    public static void main(String[] args) {
        //System.out.println(solution("samurai", "ai"));
        //System.out.println(solution("sumo", "omo"));
        System.out.println(solution("abcabc", "bc"));
    }

    public static boolean solution(String str, String ending) {
        StringBuilder a = new StringBuilder(str);
        StringBuilder b = new StringBuilder(ending);
        b.reverse();
        a.reverse();

        return a.toString().startsWith(b.toString());
    }
}

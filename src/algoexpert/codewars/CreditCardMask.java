package algoexpert.codewars;

public class CreditCardMask {
    public static void main(String[] args) {
        System.out.println(maskify("4556364607935616"));
        System.out.println(maskify("64607935616"));
        System.out.println(maskify("1"));
        System.out.println(maskify(""));
        System.out.println(maskify("Skippy"));
        System.out.println(maskify("Nananananananananananananananana Batman!"));
    }

    public static String maskify(String str) {
        int size = str.length();
        if (size <= 4) {
            return str;
        }
        return "#".repeat(size - 4) + str.substring(size - 4);
    }
}

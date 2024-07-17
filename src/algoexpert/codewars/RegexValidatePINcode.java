package algoexpert.codewars;

public class RegexValidatePINcode {
    public static void main(String[] args) {
        System.out.println(validatePin("1234"));
        System.out.println(validatePin("123432"));
        System.out.println(validatePin("a234"));
    }

    public static boolean validatePin(String pin) {
        return pin.matches("^\\d{4}$|^\\d{6}$");
    }
}

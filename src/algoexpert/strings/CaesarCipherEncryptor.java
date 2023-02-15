package algoexpert.strings;

public class CaesarCipherEncryptor {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        modWheel();
        //String xyz = caesarCypherEncryptor("xyz", 2);
        //System.out.println(xyz);
        //System.out.println(shiftSymbol('z', 2));
    }

    public static String caesarCypherEncryptor(String str, int shift) {
        StringBuilder cipherText = new StringBuilder();
        for (char aChar : str.toCharArray()) {
            int charPosition = alphabet.indexOf(aChar);
            int keyVal = (charPosition + shift) % alphabet.length(); //mod wheel
            char replaceVal = alphabet.charAt(keyVal);
            cipherText.append(replaceVal);
        }
        return cipherText.toString();
    }

    public static void modWheel() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i % 10);
        }
    }

}

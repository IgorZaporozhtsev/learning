package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Create analog the service: <a href="

 ">Example</a>
 *
 * Notes:
 * Maybe a problem:
 * - hash-function collision
 * - execution in a distributed system
 */
public class ShortUrlMaker {
    private static final String POSSIBLE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzAbCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String TINY_URL_HOST = "";
    private static String LONG_URL_1 = "https://www.youtube.com/watch?v=8ohqokWDloA&t=1s&ab_channel=BoualiAli";

    // We will don't use BD, we will use more simply variant with Map.
    private static Map<String, String> longUrlToShort = new HashMap<>();
    private static Map<String, String> shortUrlToLong = new HashMap<>();

    public String encode(String longUrl) {
// Check key
        if (longUrlToShort.containsKey(longUrl)) {
            return longUrlToShort.get(longUrl);
        }

        String encoded = TINY_URL_HOST + hash();
        longUrlToShort.put(longUrl, encoded);
        shortUrlToLong.put(encoded, longUrl);

        return encoded;
    }

    private String hash() {
        StringBuilder hashBuilder = new StringBuilder();
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 7; i++) {
                hashBuilder.append(random.nextInt(POSSIBLE_SYMBOLS.length()));
            }
            if (!shortUrlToLong.containsKey(hashBuilder.toString())) {
                return hashBuilder.toString();
            }
            hashBuilder.setLength(0);
        }
    }

    public String decode(String shortUrl) {
        return shortUrlToLong.get(shortUrl);
    }

    public static void main(String[] args) {
        var instance = new ShortUrlMaker();
        String actualShort = instance.encode(LONG_URL_1);
        String actualLong = instance.decode(actualShort);
        String expected = LONG_URL_1;
        System.out.println("Long URL: " + LONG_URL_1 + " , short URL: " + actualShort);
    }

}
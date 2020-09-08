package cources.stepic.base.tutorial;

import java.nio.charset.StandardCharsets;

public class Simvol {

    public static void main(String[] args) {


        for (byte b : "Ы".getBytes(StandardCharsets.UTF_8)) {
            System.out.printf("%d ", Byte.toUnsignedInt(b));
        }

    }
}

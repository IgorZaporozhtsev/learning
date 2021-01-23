package JavaCore.HashCode_Equals;

import java.util.Objects;

public class HashViewClass {
    public static void main(String[] args) {
        BlackBox blackBox = new BlackBox(15, 123);
        int hCode;
        hCode = blackBox.hashCode();
        System.out.println(hCode);
        System.out.println(Objects.hashCode(634));
    }

    public static class BlackBox{
        int varA;
        int varB;

        BlackBox(int varA, int varB){
            this.varA = varA;
            this.varB = varB;
        }
    }

}

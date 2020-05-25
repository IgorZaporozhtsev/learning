package JavaCore.HashCode_Equals;

public class HashViewClass {
    public static void main(String[] args) {
        BlackBox blackBox = new BlackBox(15, 123);
        int hCode;
        hCode = blackBox.hashCode();
        System.out.println(hCode);
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

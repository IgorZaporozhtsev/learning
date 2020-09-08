package JavaCore.String;

public class LesClass {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        String str = "ABC";
        str += "DEF";

        String str2 = "one".concat("two").concat("three");

        stringBuffer.append("DDD").append("EEE");
        stringBuilder.append("FFF").append("GGG");
        System.out.println(str + " " +str2 + " " + stringBuffer.toString() + " " + stringBuilder.toString());//ABCDEF onetwothree DDDEEE FFFGGG
    }
}

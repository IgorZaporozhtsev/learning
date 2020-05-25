package cources.stepic.base.ObjectTask;

public class ASCII {

    public static void main(String[] args) {

        byte[] text2 = {74, 65, 86, 65, 68, 79, 67, 83};
        byte[] text3 = {74, 54, 86, 65, 43, 79, 67, 83};


        AsciiCharSequence ascii = new AsciiCharSequence(text2);
        AsciiCharSequence ascii2 = new AsciiCharSequence(text2);


//       String a  = new String("текст");
//            public String(char a[]) {
//            this.value = Arrays.copyOf(value, value.length);
//        }
//
//      // a = new String("здравствуйте");
//



        System.out.println(ascii.toString());
        System.out.println(ascii.length());

        text2 [0] = 73;
        System.out.println(ascii);

        System.out.println(ascii.charAt(0));
        System.out.println(ascii.subSequence(5, 8));
    }
}



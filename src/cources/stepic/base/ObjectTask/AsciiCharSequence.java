package cources.stepic.base.ObjectTask;

public class AsciiCharSequence implements CharSequence {

    byte[] text;


    public AsciiCharSequence(byte[] text2){
        this.text = text2;

     //   this.text = Arrays.copyOf(text, text.length);
    }


    @Override
    public String toString() {
        return new String(text);
    }

    @Override
    public int length() {
        return text.length;
    }

    @Override
    public char charAt(int index) {
        return (char) text[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence sequence = new AsciiCharSequence(text);
        return  sequence;
    }
}

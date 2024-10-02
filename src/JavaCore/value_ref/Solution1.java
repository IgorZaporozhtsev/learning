package JavaCore.value_ref;

public class Solution1 {

    public static void main(String[] args) {
        int i = 10;
        System.out.println(changeValue(i));
        //System.out.println(i);
    }

    static int changeValue(int k){ // в метод копирует значение переменной i в переменную k и дальше использует как локальную
        k = 30; //30 это значение
        return k;
    }
}

class A{
    int a =20;
}
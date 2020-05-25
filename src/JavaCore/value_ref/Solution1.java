package JavaCore.value_ref;

public class Solution1 {

    public static void main(String[] args) {
        int i = 0;
        changeValue(i);
        System.out.println(i);
    }

    static void changeValue(int k){ // в метод копирует значение переменной i в переменную k и дальше использует как локальную
        k = 30; //30 это значение
    }
}

class A{
    int a =20;
}
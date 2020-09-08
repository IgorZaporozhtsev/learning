package cources.stepic.base.base.MassivStroki;

/*Реализуйте метод, проверяющий, является ли заданная строка палиндромом.
Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
 При определении "палиндромности" строки должны учитываться только буквы и цифры. А пробелы, знаки препинания,
  а также регистр символов должны игнорироваться. Гарантируется, что в метод попадают только строки,
  состоящие из символов ASCII (цифры, латинские буквы, знаки препинания).
   Т.е. русских, китайских и прочих экзотических символов в строке не будет.*/


public class Str2310 {

    public static void main(String[] args) {

        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean isPalindrome(String text) {


        String stroka = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return new StringBuilder(stroka.toLowerCase()).reverse().toString().equals(stroka);


    }
}

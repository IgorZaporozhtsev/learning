package MyExemples;

import java.util.Scanner; // импортируем класс

/**
 * Created by Igor on 19.12.2016.
 */
public class Tsikli1 {

        //	Вывести на экран горизонтальную линию из звёздочек. Число звездочек указывает пользователь.
/*
 Скорее всего выставлена настройка Optimize import on the fly, при которой идея очищает все неиспользуемые импорты.
 Находится она в Settings->Editor->Auto Import.
 удобнее не объявлять импорты заранее, а просто писать код. По нажатию Alt+Enter idea предложит подключить нужный пакет.
bv* */
        public static void main(String[] args) {
                System.out.print("Введите количество звездочек которое вы хотите увидеть"+"\n");
                Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
                String number = sc.next();
                int result = Integer.parseInt(number);

                for (int i = 0; i < result; i++) {
                        System.out.print("* ");
                }





        }
}

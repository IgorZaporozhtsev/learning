package cources.stepic.base.tutorial;

public class Gen2<T extends Number> {

    // Класс Stats - пример бе зуспеwой попытки создать
// обобщенный класс для вычисления среднего значения
// массива чисел заданного типа

// Этот класс содержит оmи.бку !

    T[] nums; //это массив элементов типа Т
    // передать конструктору ссылку на массив значений типа Т

    Gen2(T[] о) {
        nums = о;
    }


// возвратить значение типа douЬle в любом случае

    double sum = 0.0;

    double avarage() {

        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
           sum += nums[i].doubleValue(); //ОШИБКА !!!
        }
        return sum / nums.length;

    }

}

package JavaCore.value_ref;

public class Solution {

    public static void main(String[] args) {
        Dog dog = new Dog("Max");
        foo(dog);
        System.out.println("Имя 1-го обьекта " + dog.name);
    }

    public static void foo(Dog d) {
        //ссылки на обьекты передаються по значеннию
        //тут ссылка dog скопировалась в d (тоесть d указывает на тот же обьект)
        d.name = "Joff";
        // значит при изменение поля name будет меняться и для dog и для d
        d = new Dog("Bob"); // тут мы поменяли направление ссылки наша ссылка указывет на новый обьект уже не связаным с обьектом dog
        System.out.println("Имя 2-го обьекта " + d.name);
        //new Dog("Bob") это новое значение которое не повлияло на dog тоесть dog не поменялся на new Dog("Bob");
    }
}

class Dog{
    String name;
    Dog(String name) {
        this.name = name;
    }
}


package JavaCore.String;

public class ImmutableString {

    public static void main(String[] args) {
        //---------example_1------------------
        String s1 = "Hello";
        String s2 = s1;
        s1 = "Help!";

        System.out.println("example_1 s2 =  " +  s2); //Hello  (if String was mutable output would be: Help)
        System.out.println("example_1 s1 = " +  s1 + "\n"); //Help

        //---------example_2------------------
        String name = "bus";
        String name2 = name;

        name.concat(name2); //не работает. Мы пытаемся изменить переменную name
        name =  name.concat(" is move"); //так сработает. Мы присваиваем (меняем то куда указывает ссылка) новое значение.
        // Создаеться новый обект с результатом concat на который ссылается ссылка name


        System.out.println("example_2 name: " +  name);
        System.out.println("example_2 name2: " +  name2  + "\n");

        //---------example_3------------------
        String s = "some text";
        s.substring(0,4);
        System.out.println("example_3 " +  s); // still printing "some text"
        String a = s.substring(0,4);
        System.out.println("example_3 " +  a); // prints "some"

    }
}

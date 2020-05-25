package JavaCore.Clonable.ShallowCloning;

public class Program{

    public static void main(String[] args) {

        //-------без клонирования
        Person tom = new Person("Tom", 23);
        System.out.println("без клонирования " + tom.getName() +" "+ tom.getAge());      // Person Tom

        Person bob = tom;
        bob.setName("Bob");
        bob.setAge(10);
        System.out.println("без клонирования " + bob.getName() +" "+ bob.getAge());      // Person Bob

        //-------с клонированием

        System.out.println("\n");
        try{
            Person tom1 = new Person("Tom", 23);
            Person bob2 = tom1.clone();
            bob2.setName("Bob");
            System.out.println("c клонированием " + tom1.getName() +" "+ tom1.getAge());      // Person Tom
        }
        catch(CloneNotSupportedException ex){

            System.out.println("Cloneable not implemented");
        }
    }
}
class Person implements Cloneable{ // 1)нужно реализовать интрефейс Cloneable
        private String name;
        private int age;

        //-----------------Method Clone---------------------------
        public Person clone() throws CloneNotSupportedException{
            Person newPerson = (Person) super.clone(); // 2)переопределить метод clone()
            return newPerson;                          // метод возвращает protected native Object clone()

        }


    Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age){

        this.age = age;
    }


}
package design_patterns.singleton2;

public class SingletonEx {
    public static void main(String[] args) {
        System.out.println(SingletonNew.SINGLETON.hashCode());
        System.out.println(SingletonNew.SINGLETON.hashCode());
        System.out.println(SingletonNew.SINGLETON.hashCode());
        System.out.println(SingletonNew.SINGLETON.hashCode());
        System.out.println(SingletonNew.SINGLETON.hashCode());
    }



}

//не ленивая реализация Синглтона
class SingletonNew{
   static final SingletonNew SINGLETON = new SingletonNew();
}

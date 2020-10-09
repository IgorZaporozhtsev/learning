package JavaCore.Generics;

public class GenericsProblem {
    public static void main(String[] args) {
        Box b = new Box();
        b.setItem(new Integer(5));  //Мы ложим в объект integer
        b.setItem("Hello");  //Кто то положил String

        Object o = b.getItem();
        if(o instanceof String){//Нам приходиться проверять
            System.out.println("it's String");
        }
        if(o instanceof Integer){
            System.out.println("it's Integer");
        }
    }
}


class Box {
    private Object item;

    public Object getItem(){
        return item;
    }

    public void setItem(Object o){
        item = o;;
    }
}

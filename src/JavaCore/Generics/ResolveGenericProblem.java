package JavaCore.Generics;

public class ResolveGenericProblem {
    public static void main(String[] args) {
        BoxT<Integer> b = new BoxT();
        BoxT<String> s = new BoxT();

        b.setItem(new Integer(5));
        b.setItem("Hello");             //ОШИБКА компиляции, обьект ожидает String

    }
}


class BoxT<T> {
    private T item;

    public T getItem(){
        return item;
    }

    public void setItem(T o){
        item = o;;
    }
}

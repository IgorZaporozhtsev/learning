package JavaCore.collection.stack;

import java.util.ArrayList;
import java.util.List;

public class SimpleStack<T> implements Stack<T> {

    private List<T> list = new ArrayList<T>();

    @Override
    public void push(T item) {
        list.add(0, item);
    }

    @Override
    public T pop() {
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(T item) {
        return list.contains(item);
    }
}

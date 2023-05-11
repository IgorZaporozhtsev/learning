package JavaCore.collection.queue;

public interface Queue<T> {
    void add(T item);

    T remove();

    boolean isEmpty();
}

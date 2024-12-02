package Lab3Cars;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    boolean isFull();
    int size();
    void clear();
}
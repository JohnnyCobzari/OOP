package Lab3Cars;
import java.util.ArrayList;

public class ArrayQueue<T> implements Queue<T> {
    private final ArrayList<T> items;
    private final int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        items.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size() >= capacity;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void clear() {
        items.clear();
    }
}
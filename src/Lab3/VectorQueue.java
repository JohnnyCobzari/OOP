package Lab3;
import java.util.Vector;

public class VectorQueue<T> implements Queue<T> {
    private final Vector<T> vector;
    private final int capacity;

    public VectorQueue(int capacity) {
        this.capacity = capacity;
        this.vector = new Vector<>();
    }

    @Override
    public void enqueue(T item) {
        if (!isFull()){
            vector.add(item);
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return vector.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return vector.firstElement();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public boolean isFull() {
        return vector.size() >= capacity;
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public void clear() {
        vector.clear();
    }
}
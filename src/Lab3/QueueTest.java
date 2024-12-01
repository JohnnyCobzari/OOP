package Lab3;

public class QueueTest {

    public static void main(String[] args) {
        System.out.println("Testing ArrayQueue...");
        testQueue(new ArrayQueue<>(10));

        System.out.println("\nTesting VectorQueue...");
        testQueue(new VectorQueue<>(10));

        System.out.println("\nTesting LinkedQueue...");
        testQueue(new LinkedQueue<>(10));
    }

    public static void testQueue(Queue<Integer> queue) {
        System.out.println("Enqueueing elements: 1, 2, 3");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Peek: " + queue.peek()); // Should be 1
        System.out.println("Dequeue: " + queue.dequeue()); // Should remove 1
        System.out.println("Peek after dequeue: " + queue.peek()); // Should be 2

        System.out.println("Is the queue empty? " + queue.isEmpty()); // Should be false
        System.out.println("Queue size: " + queue.size()); // Should be 2

        System.out.println("Clearing the queue...");
        queue.clear();
        System.out.println("Is the queue empty after clear? " + queue.isEmpty()); // Should be true
        System.out.println("Queue size after clear: " + queue.size()); // Should be 0

        System.out.println("Testing enqueue after clear...");
        queue.enqueue(10);
        System.out.println("Peek after enqueue: " + queue.peek()); // Should be 10
        System.out.println("Is the queue full? " + queue.isFull()); // Implementation-specific
    }
}

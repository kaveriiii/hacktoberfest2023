class CircularQueue {
    private int[] array;
    private int front; // Index of the front element
    private int rear;  // Index of the rear element
    private int capacity;
    private int size;   // Current number of elements in the queue

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        array[rear] = item;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }

        return array[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int index = front;
        do {
            System.out.print(array[index] + " ");
            index = (index + 1) % capacity;
        } while (index != (rear + 1) % capacity);

        System.out.println();
    }
}

public class CircularQueueExample {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue

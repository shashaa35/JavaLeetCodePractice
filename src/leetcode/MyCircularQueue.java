package leetcode;

public class MyCircularQueue {

    int[] data;
    int capacity;
    int size;
    int front, rear;

    public MyCircularQueue(int k) {
        data = new int[k];
        capacity = k;
        front = rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            data[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            printQueue();
            return true;
        } else {
            printQueue();
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % capacity;
            size--;
            printQueue();
            return true;
        } else {
            printQueue();
            return false;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : data[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[(rear+capacity-1)%capacity];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printQueue() {
        int start = front, end = rear;
        for (int i=0;i<size;i++) {
            System.out.printf("%d ", data[start]);
            start = (start + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyCircularQueue obj = new MyCircularQueue(5);
        boolean param_1 = obj.enQueue(3);
        obj.enQueue(98);
        obj.enQueue(7);
        obj.enQueue(6);
        obj.enQueue(5);
        obj.enQueue(2);
        boolean param_2 = obj.deQueue();
        System.out.println(obj.Front());
        System.out.println(obj.Rear());
        System.out.println(obj.isEmpty());
        obj.enQueue(2);
        System.out.println(obj.isFull());
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

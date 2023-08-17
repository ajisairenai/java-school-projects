/**
 * CacheBlockQueue class file.
 * Written by Hydreesia.
 */

public class CacheBlockQueue<T> {
    private CacheBlockQueueNode<T> head;
    private CacheBlockQueueNode<T> tail;
    private int size;

    public CacheBlockQueue() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void enqueue(T newElement) {
        CacheBlockQueueNode<T> newNode = new CacheBlockQueueNode<>(newElement, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (tail.getData().equals(newElement)) {
            tail.setCount(tail.getCount() + 1);
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T retVal = head.getData();
        if (head.getCount() > 1) {
            head.setCount(head.getCount() - 1);
        } else {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        }
        size--;
        return retVal;
    }

    public int frontOfLineRepeatCount() {
        if (isEmpty()) {
            return 0;
        }
        return head.getCount();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        String renString = "";
        CacheBlockQueueNode<T> current = head;
        while (current != null) {
            renString += current.getData().toString();
            renString += ":";
            renString += current.getCount();
            if (current.getNext() != null) {
                renString += ", ";
            }
            current = current.getNext();
        }
        return renString;
    }
}
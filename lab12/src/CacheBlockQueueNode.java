/**
 * CacheBlockQueue class file.
 * Written by Hydreesia.
 */

public class CacheBlockQueueNode<T> {
    private int count;
    private T data;
    private CacheBlockQueueNode<T> next;

    public CacheBlockQueueNode(T data, CacheBlockQueueNode<T> next) {
        this.data = data;
        this.next = next;
        count = 1;
    }

    public T getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public CacheBlockQueueNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(CacheBlockQueueNode<T> next) {
        this.next = next;
    }

}
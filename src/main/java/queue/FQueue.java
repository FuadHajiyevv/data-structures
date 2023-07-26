package queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Queue;

public class FQueue{

    private int[] array;

    private int front;

    private int rear;

    public FQueue() {
        array = new int[10];
        front = rear = -1;
    }

    public FQueue(int initialCapacity) {
        array = new int[initialCapacity];
        front = rear = -1;
    }

    public boolean add(int value) {
        if (rear + 1 == array.length) throw new IllegalStateException();
        if (front == -1 && rear == -1) front++;
        rear++;
        array[rear] = value;
        return true;
    }


    public int element() {
        if (front == -1) throw new NoSuchElementException();
        return array[front];
    }

    public boolean offer(int value) {
        if (rear + 1 == array.length) return false;
        front++;
        rear++;
        array[rear] = array[front] = value;
        return true;
    }

    public Integer peek() {
        if (front == -1) return null;
        return array[front];
    }

    public Integer poll() {
        if (front == -1 && rear == -1) return null;
        int element = array[front];
        front++;
        if (front != array.length) return element;
        throw new NoSuchElementException();
    }

    public int remove() {
        if (front == -1 && rear == -1) throw new NoSuchElementException();
        int element = array[front];
        front++;
        if (front != array.length) return element;
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        if (front == -1 && rear == -1) return Arrays.toString(Collections.emptyList().toArray());
        int[] elementsNotOverTop = Arrays.copyOfRange(array, front, rear + 1);
        return Arrays.toString(elementsNotOverTop);
    }
}

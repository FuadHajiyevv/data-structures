package linkedlists.singly;

import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedList<T> implements Iterable<T> {
    private Node<T> head;

    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public void add(T value) {
        if (size == 0) {
            size++;
            head = new Node<>(value);
            tail = head;
            return;
        }
        size++;
        Node<T> node = new Node<>(value);
        tail.next(node);
        tail = node;
    }

    public void add(int index, T value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        tail = head;
        for (int i = 0; i < size; i++) {
            if (i == 1) {
                tail = head.getNext();
            }
            if (i > 1) {
                Node<T> node = tail.getNext();
                tail = node;
            }
            if (i == index) {
                Node<T> node = tail;
                node.setValue(value);
                break;
            }
        }
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return head.getValue();
        }
        nextMethod(index);
        return tail.getValue();
    }

    public void delete(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            head = head.getNext();
            return;
        } else if (index == size - 1) {
            getNode(index - 1).setNext(null);
            return;
        }
        Node<T> previous = getSingleNode(index - 1);
        Node<T> next = getSingleNode(index + 1);
        previous.setNext(next);
    }

    private Node<T> getNode(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return head;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        tail = current;
        return tail;
    }

    private void nextMethod(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        tail = current;
    }

    public int indexOf(T value){
        for (int i = 0; i < size ; i++) {
            if(get(i).equals(value)) return i;
        }
        return -1;
    }


    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(value)) return true;
        }
        return false;
    }

    private Node<T> getSingleNode(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        tail = head;
        for (int i = 0; i <= index - 1; i++) {
            tail = tail.getNext();
            if (i == index - 1) {
                return tail;
            }
        }
        return tail;
    }

    public Node<T> getHead() {
        return head;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        return "[" + head + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public Iterator<T> iterator() {
        return new SinglyLinkedListIterator<T>(this);
    }
}

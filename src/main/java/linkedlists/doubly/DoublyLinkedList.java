package linkedlists.doubly;

import java.util.Collections;

public class DoublyLinkedList {
    private int size;

    private Node head;

    private Node tail;

    public DoublyLinkedList() {
        head = tail = new Node();
    }

    public void add(int value) {
        if (head.getNext() == head.getPrevious() && size == 0) {
            size++;
            tail = head;
            tail.setValue(value);
            return;
        }
        size++;
        Node node = tail;
        tail.setNext(new Node(value));
        tail = tail.getNext();
        tail.setPrevious(node);
    }

    public void add(int index, int value) {
        if (index >= size) throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        Node node = new Node(value);
        if (this.get(index) == head) {
            node.setNext(head);
            node.setPrevious(null);
            head.setPrevious(node);
            head = node;
            size++;
            return;
        }
        node.setNext(this.get(index));
        node.setPrevious(this.get(index).getPrevious());
        this.get(index).getPrevious().setNext(node);
        this.get(index).setPrevious(node);
        size++;
    }

    public Node get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        Node temp;
        if (index > size / 2) {
            temp = tail;
            for (int i = 0; i < (size - index) - 1; i++) {
                temp = temp.getPrevious();
            }
            return temp;
        }
        temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public void delete(int index) {
        if (index >= size) throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        if (get(index) == head) {
            head = head.getNext();
            head.setPrevious(null);
            return;
        }
        if (get(index) == tail) {
            tail = tail.getPrevious();
            tail.setNext(null);
            return;
        }
        this.get(index).getPrevious().setNext(this.get(index).getNext());
        this.get(index).getNext().setPrevious(this.get(index).getPrevious());
    }

    public void deleteByValue(int value) {
        if (!contains(value)) throw new IllegalArgumentException(String.format("There is no such item in the list: %s", value));
        if (get(indexOf(value)) == head) {
            head = head.getNext();
            head.setPrevious(null);
            return;
        }
        if (get(indexOf(value)) == tail) {
            tail = tail.getPrevious();
            tail.setNext(null);
            return;
        }
        this.get(indexOf(value)).getPrevious().setNext(this.get(indexOf(value)).getNext());
        this.get(indexOf(value)).getNext().setPrevious(this.get(indexOf(value)).getPrevious());
    }

    ;

    public int indexOf(int value) {
        int counter = 0;
        Node temp = head;
        for (; temp.getNext() != null; temp = temp.getNext()) {
            if (temp.getValue() == value) return counter;
            counter++;
        }
        return counter;
    }

    public boolean contains(int value) {
        Node temp = head;
        for (; temp.getNext() != null; temp = temp.getNext()) {
            if (temp.getValue() == value) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        return size == 0 ? Collections.emptyList().toString() : String.format("[%s]", head);
    }
}

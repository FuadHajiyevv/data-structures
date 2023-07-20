package unilinkedlist;

public class SinglyLinkedList {
    private Node head;

    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public void add(int value) {
        if (size == 0) {
            size++;
            head = new Node(value);
            tail = head;
            return;
        }
        size++;
        Node node = new Node(value);
        tail.next(node);
        tail = node;
    }

    public void add(int index, int value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        tail = head;
        for (int i = 0; i < size; i++) {
            if (i == 1) {
                tail = head.getNext();
            }
            if (i > 1) {
                Node node = tail.getNext();
                tail = node;
            }
            if (i == index) {
                Node node = tail;
                node.setValue(value);
                break;
            }
        }
    }

    public int get(int index) {
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
        Node previous = getSingleNode(index - 1);
        Node next = getSingleNode(index + 1);
        previous.setNext(next);
    }

    private Node getNode(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return head;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        tail = current;
        return tail;
    }

    public void nextMethod(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        tail = current;
    }


    public boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (get(i) == num) return true;
        }
        return false;
    }

    public Node getTail() {
        return tail;
    }

    private Node getSingleNode(int index) {
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

    public Node getHead() {
        return head;
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "[" + head + "]";
    }
}

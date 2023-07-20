package unilinkedlist;

public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        next = null;
        this.value = value;
    }

    public void next(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return next != null ? value + "," + next : String.valueOf(value);
    }
}

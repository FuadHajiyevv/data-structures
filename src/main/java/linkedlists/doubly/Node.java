package linkedlists.doubly;

public class Node {
    private int value;
    private Node next;
    private Node previous;

    public Node(int value) {
        next = null;
        previous = null;
        this.value = value;
    }

    public Node(){
        next = null;
        previous = null;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
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

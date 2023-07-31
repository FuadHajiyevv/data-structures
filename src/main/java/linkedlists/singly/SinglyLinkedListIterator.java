package linkedlists.singly;

import java.util.Iterator;

public class SinglyLinkedListIterator<T> implements Iterator<T> {
    Node<T> current;

    public SinglyLinkedListIterator(SinglyLinkedList<T> list){
        current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T data = current.getValue();
        current = current.getNext();
        return data;
    }
}

package unilinkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(9);
        singlyLinkedList.add(5);
        singlyLinkedList.add(10);
        singlyLinkedList.add(4,2);
        System.out.println(singlyLinkedList);
        System.out.println(singlyLinkedList.contains(4));
        System.out.println(singlyLinkedList.size());
        singlyLinkedList.delete(4);
//        System.out.println(singlyLinkedList.get(4));
        System.out.println(singlyLinkedList.get(3));;

        System.out.println(singlyLinkedList);
    }
}

package MidtermStudy;

import java.util.NoSuchElementException;

public class MidtermStudy_LinkedList {
    public static void main(String[] args){
        IntLinkedList list = new IntLinkedList();
        list.insertFront(123);
        list.insertFront(456);
        list.insertAfter(100, list.head.getNext());
        list.insertAfter(777, list.head.getNext());
        list.print();
        System.out.println();
        System.out.println("길이: " + list.size);
        System.out.println("777이 " + list.search(77) + "번 째에 있다.");
        list.deleteAfter(list.head.getNext().getNext());
        list.print();
    }
}


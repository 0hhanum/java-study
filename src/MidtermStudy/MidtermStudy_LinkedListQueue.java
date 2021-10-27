package MidtermStudy;

import java.util.NoSuchElementException;

public class MidtermStudy_LinkedListQueue {
    public static void main(String[] args){
        LinkedListQueue queue = new LinkedListQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.print();
        queue.remove();
        queue.print();
    }
}

class LinkedListQueue{
    private IntNode front, rear;
    private int size;
    public LinkedListQueue(){
        front = rear = null;
        size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return (size == 0); }

    public void add(int newItem){
        IntNode newNode = new IntNode(newItem, null);
        if(isEmpty()) front = newNode;
        else rear.setNext(newNode);
        rear = newNode;
        size++;
    }
    public int remove(){
        if(isEmpty()) throw new NoSuchElementException();
        int frontItem = front.getItem();
        front = front.getNext();
        size--;
        if(isEmpty()) rear = null; // 만약 전부 삭제되었다면 front 는 getNext 에서 null 로 설정됨.
        return frontItem;
    }
    public void print(){
        IntNode node = front;
        for(int i=0;i<size;i++){
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
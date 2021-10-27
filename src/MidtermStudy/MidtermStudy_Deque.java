package MidtermStudy;

import java.util.NoSuchElementException;


public class MidtermStudy_Deque{
    public static void main(String[] args){
        DLinked_Deque deque = new DLinked_Deque();
        deque.addFront(1); deque.printDeque();
        deque.deleteRear(); deque.printDeque();
        deque.addRear(1); deque.printDeque();
        deque.addFront(3); deque.printDeque();
        deque.addFront(4); deque.printDeque();
        deque.deleteRear(); deque.printDeque();
        deque.deleteRear(); deque.printDeque();
        deque.addRear(50); deque.printDeque();
        deque.addFront(30); deque.printDeque();
        deque.deleteFront(); deque.printDeque();

    }
}

class DLinked_Deque {
    private DNode front, rear;
    private int size;
    public DLinked_Deque(){ // 생성자.
        front = rear = null;
        size = 0;
    }
    public int size(){ return size; }
    public boolean isEmpty(){ return (size == 0);}
    public void addFront(int newItem){
        DNode newNode = new DNode(newItem, null, null);
        if(isEmpty()){ // 데크가 비있다면 front 과 rear 가 모두 newNode 가 된다.
            front = rear = newNode;
        } else {
            // 새로운 노드가 front 가 되어 이전의 front 와 서로를 가리킨다.
            front.setPrevious(newNode);
            newNode.setNext(front);
            front = newNode;
        }
        size++;
    }
    public void addRear(int newItem){
        // addFront 와 동일한 논리.
        DNode newNode = new DNode(newItem, null, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
        }
        size++;
    }
    public int deleteFront(){
        if(isEmpty()) throw new NoSuchElementException();
        int item = front.getItem();
        // front 다음 노드를 front 로 지정한다.
        DNode nextFront = front.getNext();
        front = nextFront;
        size--;
        // 만약 노드가 하나 남아있었을 경우, 삭제하면 빈 데크가 되므로 rear 도 null 로 지정한다.
        if(isEmpty()) rear = null;
        return item;
    }
    public int deleteRear(){
        if(isEmpty()) throw new NoSuchElementException();
        int item = rear.getItem();
        // rear 이전 노드를 rear 로 지정한다.
        DNode nextRear = rear.getPrevious();
        rear = nextRear;
        size--;
        // 만약 노드가 하나 남아있었을 경우, 삭제하면 빈 데크가 되므로 rear 도 null 로 지정한다.
        if(isEmpty()) front = null;
        return item;
    }
    public int getFront(){
        return front.getItem();
    }
    public int getRear(){
        return rear.getItem();
    }
    public void printDeque(){
        DNode currentNode = front;
        for(int i=0; i<size; i++){
            System.out.print(currentNode.getItem() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

}

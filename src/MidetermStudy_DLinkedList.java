import java.util.NoSuchElementException;

public class MidetermStudy_DLinkedList {
    public static void main(String[] args){
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.insertAfter(dLinkedList.head, 50);
        dLinkedList.insertAfter(dLinkedList.head.getNext(), 500);
        dLinkedList.insertBefore(dLinkedList.tail, 300);
        dLinkedList.print();
        dLinkedList.delete(dLinkedList.head.getNext().getNext());
        dLinkedList.print();
    }
}

class DNode{ // 이중연결 노드
    private int item;
    private DNode previous;
    private DNode next;

    public DNode(int newItem, DNode previous, DNode next){
        item = newItem;
        this.previous = previous;
        this.next = next;
    }
    public int getItem() { return item; }
    public DNode getPrevious() { return previous; }
    public DNode getNext() { return next; }
    public void setItem(int newItem){ item = newItem; }
    public void setPrevious(DNode p){previous = p;}
    public void setNext(DNode n){next = n;}
}

class DLinkedList{
    protected DNode head, tail;
    protected int size;
    public DLinkedList(){
        // head, tail 은 실제로 항목을 저장하지 않는 dummy 노드. (Size 가 0이다)
        head = new DNode(0, null, null);
        tail = new DNode(0, head, null);
        head.setNext(tail); // 순서
        size = 0;
    }
    public void insertBefore(DNode node, int newItem){ // node 앞에 삽입
        DNode prevNode = node.getPrevious();
        DNode newNode = new DNode(newItem, prevNode, node);
        prevNode.setNext(newNode);
        node.setPrevious(newNode);
        size++;
    }
    public void insertAfter(DNode node, int newItem){
        DNode afterNode = node.getNext();
        DNode newNode = new DNode(newItem, node, afterNode);
        afterNode.setPrevious(newNode);
        node.setNext(newNode);
        size++;
    }
    public void delete(DNode node){ // node 삭제
        if(node == null) throw new NoSuchElementException();
        DNode previousNode = node.getPrevious();
        DNode nextNode = node.getNext();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        node.setPrevious(null); node.setNext(null); // 연결 끊어주기.
        size--;
    }
    public void print(){
        DNode node = head.getNext();
        for(int i=0;i<size;i++){
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
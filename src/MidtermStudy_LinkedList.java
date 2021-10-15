import java.util.NoSuchElementException;

public class MidtermStudy_LinkedList {
    public static void main(String[] args){
        IntSLinkedList list = new IntSLinkedList();
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

class IntNode{ // 노드 클래스
    private int item;
    private IntNode next; // 주소

    public IntNode(int newItem, IntNode next){
        this.item = newItem;
        this.next = next;
    }

    public int getItem() { return item; } // node 의 getter.
    public IntNode getNext() { return next; }
    public void setItem(int newItem){ this.item = newItem; } // setter
    public void setNext(IntNode node){ this.next = node; }
}

class IntSLinkedList{
    protected IntNode head; // 연결리스트의 첫 노드.
    protected int size; // 리스트 요소 개수.

    public IntSLinkedList(){
        head = null;
        size = 0;
    }
    public int search(int target){ // 값을 이용해 그 노드가 몇 번째인지 찾기. 번째를 반환한다.
        IntNode headNode = head;
        for(int k=0;k<size;k++){
            if(target == headNode.getItem()) return k;
            headNode = headNode.getNext();
        }
        return -1; // 없으면 -1 반환.
    }
    public void insertFront(int newItem){ // head 자리에 새 노드 끼워넣기.
        this.head = new IntNode(newItem, this.head); // head 가 얘가되고, 원래 head 는 얘가 가리킨다.
        size++;
    }
    public void insertAfter(int newItem, IntNode node){ // node 뒤에 삽입하기. a->b->c 에서 b 뒤에 삽입하면 a->b->x->c
        node.setNext(new IntNode(newItem, node.getNext()));
        size++;
    }
    public void deleteFront(){ // 첫 노드 삭제.
        if(size == 0) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }
    public void deleteAfter(IntNode node){ // node 뒤의 노드 삭제.
        if(node == null || node.getNext() == null) throw new NoSuchElementException();
        IntNode nextNode = node.getNext();
        node.setNext(nextNode.getNext());
        nextNode.setNext(null); // 기존 연결 끊어내기.
        size--;
    }
    public void print(){
        IntNode node = head;
        for(int i=0;i<size ; i++){
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
    }
}
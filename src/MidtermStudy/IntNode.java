package MidtermStudy;

public class IntNode{ // 노드 클래스
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


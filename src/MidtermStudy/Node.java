package MidtermStudy;

public class Node<E> {
    private E item; // 스택 내 항목인 인스턴스 변수 item 선언 ( 제네릭 이용 )
    private Node<E> next; // 다음 노드를 가리키는 MidtermStudy.Node 의 인스턴스 변수 next 선언.

    public Node(E newItem, Node<E> node) { // 생성자. newItem 과 node 를 매개변수로 받음.
        item = newItem;
        next = node;
        // 인스턴수 변수에 생성하며 받은 인자들을 넣어준다.
    }

    public E getItem() {
        return item;
    } // item 접근자

    public Node<E> getNext() {
        return next;
    } // next 접근자

    public void setItem(E newItem) {
        item = newItem;
    } // item 설정자

    public void setNext(Node<E> newNext) {
        next = newNext;
    } // next 설정자
}

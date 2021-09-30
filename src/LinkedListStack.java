import java.util.EmptyStackException;

class Node <E> {
    private E item; // 스택 내 항목인 인스턴스 변수 item 선언 ( 제네릭 이용 )
    private Node<E> next; // 다음 노드를 가리키는 Node 의 인스턴스 변수 next 선언.
    public Node(E newItem, Node<E> node){ // 생성자. newItem 과 node 를 매개변수로 받음.
        item = newItem;
        next = node;
        // 인스턴수 변수에 생성하며 받은 인자들을 넣어준다.
    }
    public E getItem() { return item; } // item 접근자
    public Node<E> getNext() { return next; } // next 접근자
    public void setItem(E newItem) { item = newItem; }; // item 설정자
    public void setNext(Node<E> newNext){ next = newNext; } // next 설정자
}

public class LinkedListStack<E> {
    private Node <E> top; // Node 클래스형 인스턴스 변수 top 선언
    private int size; // 스택의 항목 수 나타내는 인스턴스 변수 size 선언
    public LinkedListStack() { // 생성자
        top = null; // 배열 스택에서 top 을 0으로 설정했듯 null 로 설정. 단, 여기선 인덱스가 아닌 노드이다.
        size = 0;
    }
    public int size() { return size; } // size 접근
    public boolean empty() { return size == 0; } // 스택이 비어있는지 boolean 리턴하는 메서드.
    public E top() { // top() 메서드
        if (empty()) throw new EmptyStackException(); // 스택이 비어있으면 프로그램 정지
        return top.getItem(); // top 노드의 getItem() 메서드를 실행해 노드 내 item 을 얻어온다.
    }
    public Node<E> getTopNode(){ // top 노드를 반환하는 메서드. [ 추가됨 ]
        if(empty()) throw new EmptyStackException();
        return top;
    }
    public void push(E newItem){
        top = new Node<E>(newItem, top); // top 이 새 노드로 변경, 새 노드는 기존 top 을 next 로 가리키며, top 은 새 노드가 된다.
        size ++; // 스택 항목 수 1 증가.
    }
    public void pop(){
        if (empty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
        top = top.getNext();
        // ListStack 클래스에서 새 노드가 추가되면 그 노드는 현재의 top Node 를 next 로 가진 뒤 새로운 top 이 된다.
        // 따라서 top 노드 삭제 시, top 아래 노드를 getNext() 메서드로 가져와 새로운 top 으로 변경.
        size--;
    }
}

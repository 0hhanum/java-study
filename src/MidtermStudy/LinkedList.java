package MidtermStudy;

import java.util.EmptyStackException;
import java.util.Scanner;

public class LinkedList<E> {
    private Node <E> top; // MidtermStudy.Node 클래스형 인스턴스 변수 top 선언
    private int size; // 스택의 항목 수 나타내는 인스턴스 변수 size 선언
    public LinkedList() { // 생성자
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
        // ListStack 클래스에서 새 노드가 추가되면 그 노드는 현재의 top MidtermStudy.Node 를 next 로 가진 뒤 새로운 top 이 된다.
        // 따라서 top 노드 삭제 시, top 아래 노드를 getNext() 메서드로 가져와 새로운 top 으로 변경.
        size--;
    }

    public void printList(){
        Node<E> node = top;
        for(int i=0; i<size; i++) {
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public Node<E> findNode(int index){
        Node<E> node = top;
        for (int i=0; i < index - 1; i++){ // top 노드 부터 시작하므로 index - 1
            node = node.getNext();
        }
        return node;
    }

    public void exchangeValue(Node<E> a, Node<E> b){
        // node a 와 b 의 값을 교환.
        E tmp = a.getItem();
        a.setItem(b.getItem());
        b.setItem(tmp);
    }

    public int findIndex(Node<E> node){ // node 의 인덱스를 찾아주는 메서드.
        Node<E> searchingNode = top;
        int index = 0;
        for(int i=1; i<size + 1; i++){
            if(searchingNode == node) {
                index = i;
                break;
            }
            searchingNode = searchingNode.getNext();
            // node 를 찾으면 인덱스를 반환, 아니면 계속 탐색한다. 인덱스는 1부터 설정하였다.
        }
        return index;
    }

    public static LinkedList<Integer> createTenSizeList(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();  // 제네릭 타입의 클래스기 때문에 Integer wrapper 를 사용합니다.
        System.out.println("10개의 숫자를 입력하세요. (1, 2, ...)  >");
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i < 10; i++){
            int num = scanner.nextInt();
            linkedList.push(num); // 리스트에 10 번 삽입.
        }
        scanner.close();
        System.out.print("입력된 숫자 > ");
        linkedList.printList();

        return linkedList;
    }

}

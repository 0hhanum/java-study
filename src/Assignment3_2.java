import java.util.NoSuchElementException;
import java.util.Scanner;
/*
요세푸스 문제
배열과 이중연결 리스트
원형 리스트를 이용해 푼다.
배열을 이용할 경우:

크기 N 의 원형 배열을 만들고 1~N 을 집어넣은 뒤 원형 배열을 돌며 한 사람이 제거될 때마다
1. 매번 그 자리를 제외하고 배열을 resizing 하는 방식을 생각했다.

이중 링크드리스트의 경우, 원형 이중 링크드리스트를 만들어 원형 리스트를 돌며
2. 한 사람이 죽을 때마다 그 노드를 제거하는 방식을 생각했다.

1의 경우, 접근을 최적화하면 O(1) 에 수행할 수 있지만, 매번 배열 크기를 축소시켜야 하므로 최악경우 O(N)의 연산이 N 번 반복된다. 즉 O(N^2) 이다.
2의 경우, 배열 크기를 축소시킬 필요는 없으나 매번 다음 k 번째를 찾아 방문해야 하니 접근에 O(k) 가 소요되며 N 번 반복된다. 즉 O(kN) 이고 삭제에는 O(1)
이니 원형 이중연결리스트를 사용하는 것이 유리하다.
 */
public class Assignment3_2 {
    public static void main(String[] args) {
        CircleList list = new CircleList();
        Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int K = scanner.nextInt();
        scanner.close();
        for(int i=1; i<N+1; i++){
            list.insert(i);
            // 1~N 까지 리스트에 대입
        }
        DNode node = list.getLast();
        System.out.print("<");
        for(int i=1; i<N+1; i++){
            for(int j=0;j<K;j++){
                // k 만큼 이동한다.
                node = node.getNext();
            }
            int item = list.delete(node);

            // 마지막 원소는 "," 를 출력하지 않는다.
            if(i != N){
                System.out.print(item + ", ");

            } else {
                System.out.print(item);
            }
        }
        System.out.print(">");
    }


}


class CircleList{ // 이중연결 노드를 사용
    private DNode last; // 리스트의 마지막 노드.
    private int size;
    public CircleList(){ // 생성자
        this.last = null;
        this.size = 0;
    }
    public DNode getLast() { return last; }
    public boolean isEmpty() { return (this.size == 0); } // 리스트가 비었는지 판별.
    public void insert(int newItem){
        DNode newNode = new DNode(newItem, null, null);
        if (isEmpty()){
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            // 만약 첫 노드라면 prev 와 next 가 자기 자신을 가리키도록 한다.
        } else {
            DNode First = last.getNext();
            newNode.setNext(First);
            newNode.setPrevious(last);
            First.setPrevious(newNode);
            last.setNext(newNode);
            // 만약 첫 노드가 아니라면 last 뒤에 newNode 를 이어준다.
        }
        last = newNode; // 새로운 노드가 last 가 됨.
        size++;
    }
    public int delete(DNode node){
        // 삭제 메서드. 노드 삭제 후 삭제 된 노드의 item 을 반환한다.
        if (isEmpty()) throw new NoSuchElementException();
        int item = node.getItem();
        if(size == 1){
            // 리스트에 노드 하나뿐일 경우
            last = null;
            node.setPrevious(null);
            node.setNext(null);
        } else {
            // 아닐 경우 해당 노드 앞뒤 노드를 서로 이어준다.
            DNode prevNode = node.getPrevious();
            DNode nextNode = node.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);
        }
        if(node == last){
            // 만약 삭제 노드가 last 였을 경우, last 이전 노드를 last 로 지정해준다.
            last = node.getPrevious();
//            node.setNext(null);
//            node.setPrevious(null);
            // 연결을 끊어준다.
        }
        size--;
        return item;
    }
    public void print(){ // 테스트용
        DNode node = last.getNext();
        for(int i=0;i<size;i++){
            System.out.print(node.getItem() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}

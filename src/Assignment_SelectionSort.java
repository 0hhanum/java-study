import java.util.Scanner;

/*
배열은 교환 시마다 전부 뺐다가 다시 넣어야 할 것같아 링크드리스트 선택.
근데 단뱡향 링크드다 보니 이전 노드를 기억 못해 오히려 번거로움, 단순히 값만 다루는 게 아니라
최고 노드를 저장해가며 진행하다보니 불편. ** 어려웠던 점이 아니라 장단점 쓰는거다 정신차려라
=> 시스템적 문제점도 추가하기.
 */

public class Assignment_SelectionSort {
    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        // 과제 1의 링크드리스트 스택을 활용했습니다. 탑 노드 반환을 위해 getTopNode() 메서드를 추가했습니다.
        // 테스트하며 진행하기 위해 printStack() 메서드를 추가했습니다.
        // 제네릭 타입의 클래스기 때문에 Integer wrapper 를 사용합니다.
        System.out.println("10개의 숫자를 입력하세요. (1, 2, ...)  >");
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i < 10; i++){
            int num = scanner.nextInt();
            stack.push(num); // 리스트에 10 번 삽입.
        }
        scanner.close();

        Node<Integer> startNode = stack.getTopNode(); // 기준 노드를 얻어옴.
        for (int i=0; i < 10; i++){
            Node<Integer> maxNode = startNode;
            // 매번 기준값과 나머지 값을 비교하기 때문에 for 문이 돌 때마다 maxNode 설정.
            Node<Integer> compareNode = startNode;
            // 비교 노드 선언. maxNode 와 startNode 를 바꿔줘야 하기 때문에 노드를 복제해 진행한다.
            for(int j = 0; j < 10 - i - 1; j++){ // 9번, 8번, ... 1번 이렇게 스택을 돈다.
                compareNode = compareNode.getNext(); // 다음 노드를 얻어온다.
                int maxNum = maxNode.getItem();
                int compareNum = compareNode.getItem();
                if (compareNum > maxNum) maxNode = compareNode; // maxNode & compareNode 비교해 maxNode 설정.
            }
            // for 문이 끝나면 기준점에서부터 끝까지의 가장 큰 노드가 구해진다.
            // max 와 start 노드를 교환한 뒤, start 노드를 max 의 다음 노드로 설정한다.
            Node<Integer> tmp = new Node<Integer> (maxNode.getItem(), maxNode.getNext());
            maxNode.setNext(startNode.getNext());
            maxNode.setItem(startNode.getItem());
            startNode.setNext(tmp.getNext());
            startNode.setItem(tmp.getItem());
            startNode = maxNode.getNext(); // max 와 start 의 자리를 교환했으므로 max 의 next() 이용해 다음 start 를 지정해준다.
        }

        for(int i=0; i < 9; i++){ // 정렬된 스택 출력
            Node<Integer> node = stack.getTopNode();
            System.out.print(node.getItem() + " ");
            stack.pop();
        }
    }
}

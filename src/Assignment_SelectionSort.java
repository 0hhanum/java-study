import java.util.Scanner;

/*
배열은 교환 시마다 전부 뺐다가 다시 넣어야 할 것같아 링크드리스트 선택.
근데 단뱡향 링크드다 보니 이전 노드를 기억 못해 오히려 번거로움, 단순히 값만 다루는 게 아니라
최고 노드를 저장해가며 진행하다보니 불편. ** 어려웠던 점이 아니라 장단점 쓰는거다 정신차려라
=> 시스템적 문제점도 추가하기.

결국 교체 시 이전 노드를 찾기 위해 탐색을 한번 더 해야하는 문제 발생 2o^2?
=> 최대값 탐색할 때 이전 노드와 현재 노드를 저장해 같이 들고 다니며 최대값을 찾았을 시 이전 노드를
저장하는 방법도 생각해봤는데, 두 개 이상의 노드를 저장해가며 탐색한다는 방식이 스택과 맞지 않는듯 싶어
어쩔 수 없이 이 방법으로 함. 실패했다고 생각.
 */

public class Assignment_SelectionSort {
    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(); // 제네릭 타입의 클래스기 때문에 Integer wrapper 를 사용합니다.
        // 과제 1의 링크드리스트 스택을 활용했습니다. 탑 노드 반환을 위해 getTopNode() 메서드를 추가했습니다.
        // 테스트하며 진행하기 위해 printStack() 메서드를 추가했습니다.
        // 노드 교체를 위해 exchangeNode() 메서드를 추가했습니다.
        System.out.println("10개의 숫자를 입력하세요. (1, 2, ...)  >");
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i < 10; i++){
            int num = scanner.nextInt();
            stack.push(num); // 리스트에 10 번 삽입.
        }
        scanner.close();
        stack.printStack();
        Node<Integer> startNode = stack.getTopNode(); // 기준 노드를 얻어옴.
        //
        Node<Integer> node = startNode.getNext().getNext().getNext();
        stack.exchangeNode(startNode, node);
        stack.printStack();
        //
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
            stack.exchangeNode(maxNode, startNode);
            startNode = maxNode.getNext(); // max 와 start 의 자리를 교환했으므로 max 의 next() 이용해 다음 start 를 지정해준다.
        }
//        stack.printStack();

    }
}


public class Assignment_SelectionSort {
    // 과제 1 의 링크드리스트를 활용했습니다.
    // createTenSizeList(), printList(), getTopNode() 메서드를 새로 정의하였습니다.
    public static void main(String[] args){
        LinkedList<Integer> linkedList = LinkedList.createTenSizeList();

        Node<Integer> startNode = linkedList.getTopNode(); // 기준 노드를 얻어옴.
        for (int i=0; i < 9; i++){
            Node<Integer> maxNode = startNode;
            // 매번 기준값과 나머지 값을 비교하기 때문에 for 문이 돌 때마다 maxNode 설정.
            Node<Integer> compareNode = startNode;
            // 비교 노드 선언. 루프를 돈 후 maxNode 와 startNode 를 바꿔줘야 하기 때문에 노드를 복제해 진행한다.
            for(int j = 0; j < 10 - i - 1; j++){ // 9번, 8번, ... 1번 이렇게 리스트를 돈다.
                compareNode = compareNode.getNext(); // 다음 노드를 얻어온다.
                int maxNum = maxNode.getItem();
                int compareNum = compareNode.getItem();
                if (compareNum > maxNum) maxNode = compareNode; // maxNode & compareNode 비교해 maxNode 설정.
            }
            // for 문이 끝나면 기준점에서부터 끝까지의 가장 큰 노드가 구해진다.
            // max 와 start 노드의 값을 교환한 뒤, start 노드를 현재 start 노드의 다음 노드로 설정한다.
            linkedList.exchangeValue(startNode, maxNode);
            startNode = startNode.getNext();
        }
        System.out.print("정렬된 숫자 > ");
        linkedList.printList();
    }
}

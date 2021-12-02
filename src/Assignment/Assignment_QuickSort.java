package Assignment;
import MidtermStudy.LinkedList;
import MidtermStudy.Node;


public class Assignment_QuickSort {
    /*
     문제 풀이를 위한 findNode(int i), exchangeValue(Node a, Node b), findIndex(node a)
     메서드를 MidtermStudy.LinkedList 클래스에 정의했습니다.
     findNode(int i) 는 i 번째 노드를 반환합니다.
     exchangeValue(Node a, Node b) 는 a 와 b 의 item 을 서로 교환합니다.
     findIndex(node a) 는 리스트 내에서 a 의 순서를 반환합니다.
     */
    static LinkedList<Integer> linkedList = LinkedList.createTenSizeList();
    // 클래스 변수로 메서드 밖에 리스트를 생성.
    public static void main(String[] args) {

        System.out.println("\n=======================");
        quickSort(1, linkedList.size()); // 정렬 시행.
        System.out.println("=======================");

        System.out.print("\n정렬 결과 > ");
        linkedList.printList();
    }

    public static void quickSort(int from, int to) { // 분할정복을 위해 시작, 끝점을 인자로 설정.
        int tmpFrom = from;
        int tmpTo = to; // from 과 to 부터 1칸씩 이동하며 탐색 후, 재귀로 from to 를 다시 호출해야 하기 때문에 값을 복사해 진행.
        int size = to - from ;

        if (size <= 0) return; // 부분집합의 원소가 한 개이거나 없으면 종료. (확정된 원소가 서로 붙어있을 때는 부분집합의 원소가 없다.)

        Node<Integer> pivot = linkedList.findNode(from + (size / 2)); // 부분집합의 가운데 원소를 pivot 으로 지정한다.
        Node<Integer> L = linkedList.findNode(from);
        Node<Integer> R = linkedList.findNode(to); // L 과 R 을 지정.

        boolean toggleL = false;
        boolean toggleR = false; // pivot 보다 크고 작은 원소를 찾았는지 아닌지 찾는 스위치 생성.

        while (L != R) { // L 과 R 이 만나기 전까지 반복진행.
            while (true) { // L 을 찾을 때까지 수행.
                if (L.getItem() >= pivot.getItem()) { // 해당하는 원소를 찾는다면 스위치를 켜고 if 문 탈출.
                    toggleL = true;
                    break;
                }
                else L = linkedList.findNode(++tmpFrom); // 찾지 못했다면 한 칸씩 오른쪽으로 이동하며 탐색 수행.
                if (L == R) break; // 둘이 만난다면 탈출.
            }
            while (true) {
                if (R.getItem() < pivot.getItem()) { // 해당하는 원소를 찾는다면 스위치를 켜고 if 문 탈출.
                    toggleR = true;
                    break;
                }
                else if(L != R) R = linkedList.findNode(--tmpTo);
                // 찾지 못했다면 한 칸씩 왼쪽으로 이동하며 탐색 수행. 이 때 위의 L 이동에서 R 과 겹쳤다면 이동하지 않고 종료한다.
                if(L == R) break; // 둘이 만난다면 탈출.
            }
            if (toggleL && toggleR) {
                linkedList.exchangeValue(L, R);
                if(L == pivot) pivot = R; // 만약 L 이 피봇인 경우, 피봇의 위치교환이 일어난 것이므로 변수 pivot 도 재 지정이 필요함.
                toggleL = false;
                toggleR = false; // 교환이 일어난 경우, 탐색을 계속해야 하므로 스위치를 내려준다.
            }
        }

        // 변경이 끝나면 피봇과 R 의 원소를 교환해준다.
        linkedList.exchangeValue(R, pivot);
        pivot = R; // 값을 교환했으므로 피봇의 위치 재 지정.
        int pivotIndex = linkedList.findIndex(pivot);

        System.out.print("중간 수행 결과 > ");
        linkedList.printList();
        System.out.println("현재 피봇: " + pivot.getItem());

        // pivot 을 기준으로 두 부분집합으로 나누어 정렬을 재귀 진행한다.
        quickSort(from, pivotIndex - 1);
        quickSort(pivotIndex + 1, to);
    }
}

package MidtermStudy;

import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        // 삽입을 이용한 정렬이므로 연결리스트를 사용하는 것이 수월.

        Scanner scanner = new Scanner(System.in);
        System.out.print("총 원소 개수 입력 > ");
        int length = scanner.nextInt();
        DLinkedList dLinkedList = new DLinkedList();
        DNode node = dLinkedList.head;
        for (int i = 0; i < length; i++) {
            System.out.println("원소 입력 (한 원소당 한 번씩 엔터) > ");
            dLinkedList.insertAfter(node, scanner.nextInt());
            node = node.getNext();
        }
        System.out.print("입력된 리스트 : ");
        dLinkedList.print();

        // 쉘 정렬.
        int interval = dLinkedList.getSize() / 2;
        while(interval >= 1){
            for(int i=0;i<interval;i++){
                dLinkedList = insertionSortForShellSort(dLinkedList, i, interval);
            }
            System.out.print("현재 interval "+ interval + " : ");
            dLinkedList.print();
            interval = interval / 2;
        }
        System.out.print("결과 : "); dLinkedList.print();
    }

    public static DLinkedList insertionSortForShellSort(DLinkedList dLinkedList, int startPoint ,int interval) {
        for (int i = startPoint + interval; i < dLinkedList.getSize(); i += interval) {
            // 두 번째 원소부터 삽입정렬 시작.
            DNode currentNode = dLinkedList.getNodeByIndex(i);
            int currentInt = currentNode.getItem();

            int j = i - interval;

            for (; j >= startPoint && currentInt < dLinkedList.getNodeByIndex(j).getItem(); j -= interval) {
                // sorted 된 부분과 계속 비교하며 for 문을 돈다.
                // for 문의 크기 비교문을 통과했다면 한 칸씩 밀어준다.
                DNode comparingNode = dLinkedList.getNodeByIndex(j);
                dLinkedList.getNodeByIndex(j + interval).setItem(comparingNode.getItem());
                }

            // for 문을 돌며 알맞은 위치 전 까지 한칸 씩 다 밀었으면, 알맞은 위치에 원소를 넣어준다
            dLinkedList.getNodeByIndex(j + interval).setItem(currentInt);
            dLinkedList.print();
            }
            return dLinkedList;
        }
}

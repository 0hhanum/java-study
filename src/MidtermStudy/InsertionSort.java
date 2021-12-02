package MidtermStudy;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args){
        // 삽입을 이용한 정렬이므로 연결리스트를 사용하는 것이 수월.

        Scanner scanner = new Scanner(System.in);
        System.out.print("총 원소 개수 입력 > ");
        int length = scanner.nextInt();
        DLinkedList dLinkedList = new DLinkedList();
        DNode node = dLinkedList.head;
        for (int i=0; i<length; i++){
            System.out.println("원소 입력 (한 원소당 한 번씩 엔터) > ");
            dLinkedList.insertAfter(node, scanner.nextInt());
            node = node.getNext();
        }
        System.out.println("입력된 리스트 : ");
        dLinkedList.print();

        // 삽입 정렬
        for(int i=1; i<dLinkedList.getSize();i++){
            DNode currentNode = dLinkedList.getNodeByIndex(i);
            for(int j=i-1; j>=0; j--){
                DNode compareNode = dLinkedList.getNodeByIndex(j);
                if(currentNode.getItem() > compareNode.getItem()){
                    dLinkedList.insertAfter(compareNode, currentNode.getItem());
                    dLinkedList.delete(currentNode);
                    break;
                }
                if(j == 0){ // 마지막까지 찾지 못했다면 제일 앞에 삽입
                    dLinkedList.insertBefore(compareNode, currentNode.getItem());
                    dLinkedList.delete(currentNode);
                }
            }
            System.out.println("" + i + " 단계 : ");
            dLinkedList.print();
        }
    }

}

package MidtermStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuickSort {
    static ArrayList<Integer> array;

    public static void main(String[] args){
        // 배열 입력받기.
        Scanner scanner = new Scanner(System.in);
        System.out.print("총 원소 개수 입력 > ");
        int length = scanner.nextInt();
        array = new ArrayList<Integer>(length);

        for (int i=0; i<length; i++){
            System.out.println("원소 입력 (한 원소당 한 번씩 엔터) > ");
            array.add(i, scanner.nextInt());
        }
        System.out.println("입력된 배열 : " + array.toString());
        quickSort(0, array.size() - 1);

    }
    public static void quickSort(int from, int to) {
        int size = to - from;
        if (size <= 0) return; // 부분집합 원소가 한 개이거나 없으면 종료. (확정된 원소가 서로 붙어있을 때는 부분집합의 원소가 없다.

        int pivot = array.get((to + from) / 2);
        int L = from;
        int R = to;

        boolean toggleL = false;
        boolean toggleR = false;
        // pivot 보다 크고 작은 원소를 찾았는지 아닌지 구별하는 스위치 생성.
        while(L != R){
            while (true) { // L 을 찾을 때 까지 수행.
                if (array.get(L) >= pivot) {
                    toggleL = true;
                    break;
                } else {
                    array.set(L, array.get(++L));
                    // 한 칸씩 오른쪽으로 이동
                }
                if (L == R) break; // 둘이 만난다면 탈출.
            }
            while (true) {
                if (array.get(R) < pivot) {
                    toggleR = true;
                    break;
                } else if (L != R) {
                    array.set(R, --R); // 한 칸씩 왼쪽으로 이동
                }
                if (L == R) break; // 둘이 만난다면 탈출.
            }
            if (toggleR && toggleL) {
                // L R 모두 타겟을 찾았으면 서로 변경
                int tmp = array.get(R);
                array.set(R, array.get(L));
                array.set(L, tmp);

                if (array.get(L) == pivot) pivot = array.get(R); // L 이 피봇인 경우, 위에서 피봇의 위치 변경이 일어났으므로 피봇도 변경
                toggleL = false;
                toggleR = false;
                // toggle 을 끄고 다시 while 문을 돌며 재진행
            }
        }
        // 모두 종료되면 피봇과 R 의 원소를 교환
        int pivotIndex = array.indexOf(pivot);

        array.set(pivotIndex, array.get(R));
        array.set(R, pivot);

        pivotIndex = R;

        System.out.println("중간 수행 결과 > ");
        System.out.println(array.toString());
        System.out.println("현재 피봇 : " + pivot);

        quickSort(from, pivotIndex - 1);
        quickSort(pivotIndex + 1, to);
    }
}


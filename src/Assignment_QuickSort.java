import java.util.Scanner;

// find() 메서드 생성. exchangeValue() 메서드 생성. findIndex 메서드 생성.
/*
L 은 크거나 같은 => 피봇까지 가면 멈출 수밖에 없음
R 은 작은 => 피봇을 넘어갈 수 있음
=> 그래서 L 과 R 이 만나면 피봇과 R 의 원소를 교환. => 이게 포인트임.
 */

public class Assignment_QuickSort {
    static LinkedListStack<Integer> linkedList = new LinkedListStack<Integer>();
    // 제네릭 타입의 클래스기 때문에 Integer wrapper 를 사용합니다.
    // 클래스 변수로 메서드 밖에 생성.

    public static void main(String[] args) {
        // 10 개의 숫자 입력받기.
        System.out.println("10개의 숫자를 입력하세요. (1, 2, ...)  >");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            int num = scanner.nextInt();
            linkedList.push(num); // 리스트에 10 번 삽입.
        }
        scanner.close();
        System.out.print("입력된 숫자 > ");
        linkedList.printStack();

//        System.out.println("=======================");
        quickSort(1, linkedList.size()); // 정렬 시행.
//        System.out.println("=======================");

        System.out.print("\n정렬 결과 > ");
        linkedList.printStack();
    }

    public static void quickSort(int from, int to) { // 분할정복을 위해 시작, 끝점을 인자로 설정.
        int tmpFrom = from;
        int tmpTo = to; // from 과 to 부터 1칸씩 이동하며 탐색 후, 재귀로 from to 를 다시 호출해야 하기 때문에 값을 복사해 진행.

        int size = to - from ;

        if (size <= 0) return; // 부분집합의 원소가 한 개이거나 없으면 종료. (확정된 원소가 서로 붙어있을 때는 부분집합의 원소가 없다.)
//        else if (size % 2 != 0) size++; // 부분집합 원소가 홀수개일 경우 가운데 원소를 pivot 지정 위해 1 키워줌.

        Node<Integer> pivot = linkedList.find(from + (size / 2)); // from 부터 시작해 가운데 원소를 pivot 지정. // 추가설명 필요
        Node<Integer> L = linkedList.find(from);
        Node<Integer> R = linkedList.find(to); // L 과 R 을 지정.

        boolean toggleL = false;
        boolean toggleR = false; // pivot 보다 크고 작은 원소를 찾았는지 아닌지 찾는 스위치 생성.

        while (L != R) { // L 과 R 이 만나기 전까지 진행.
            if (L.getItem() >= pivot.getItem() && !toggleL) {
                // L 값을 찾지 못한 경우에만 연산을 시행한다.
                toggleL = true; // pivot 보다 큰 값을 찾았다면 toggleL ON
            }
            if (R.getItem() < pivot.getItem() && !toggleR) { // pivot 보다 작은 값을 찾았다면 toggleR ON
                // R 값을 찾지 못한 경우에만 연산을 시행한다.
                toggleR = true;
            }
            if (toggleL && toggleR) { // L R 모두 pivot 보다 크고 작은 값을 찾았다면 값을 교환.
                linkedList.exchangeValue(L, R);
                if(L == pivot) pivot = R; // 만약 L 이 피봇인 경우, 피봇의 위치교환이 일어난 것이므로 변수 pivot 도 재 지정이 필요함.
                toggleL = false;
                toggleR = false; // 교환이 일어난 경우, 탐색을 계속해야 하므로 스위치를 내려준다.
            }

            if (!toggleL) L = linkedList.find(tmpFrom++ + 1); // pivot 보다 큰 원소를 찾지 못했을 경우 한 칸 이동.
            if (L == R) break; // L 과 R 이 바로 옆인 경우 서로 한 칸씩 이동하면 엇갈릴 수 있다.
            if (!toggleR) R = linkedList.find(tmpTo-- - 1); // pivot 보다 작은 원소를 찾지 못했을 경우 한 칸 이동.
        }
        /*
        위에서 피봇 변경 일어날 경우 피봇 재설정 필요.
        R 과 피봇 변경해줌.
         */
        // 변경이 끝나면 피봇과 R 의 원소를 교환해준다.
        linkedList.exchangeValue(R, pivot);
        pivot = R; // 값을 교환했으므로 피봇의 위치 재 지정.

        int pivotIndex = linkedList.findIndex(pivot);
        System.out.print("중간 수행 결과 > ");
        linkedList.printStack();
        System.out.println("현재 피봇: " + pivot.getItem());
        quickSort(from, pivotIndex - 1);
        quickSort(pivotIndex + 1, to); // pivot 을 기준으로 두 부분집합으로 나누어 정렬을 재귀 진행한다.
    }
}

// 22 31 8 16 2 30 10 69
// 10 3 482 319 12 3 4 5 1 7
import java.util.Scanner;

// find() 메서드 생성. exchangeValue() 메서드 생성.

public class Assignment_QuickSort {
    static LinkedListStack<Integer> linkedList = new LinkedListStack<Integer>();
    // 제네릭 타입의 클래스기 때문에 Integer wrapper 를 사용합니다.
    // 클래스 변수로 메서드 밖에 생성.

    public static void main(String[] args) {
        // 10 개의 숫자 입력받기.
        System.out.println("10개의 숫자를 입력하세요. (1, 2, ...)  >");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int num = scanner.nextInt();
            linkedList.push(num); // 리스트에 10 번 삽입.
        }
        scanner.close();
        System.out.print("입력된 숫자 > ");
        linkedList.printStack();
        System.out.println();
        quickSort(1, linkedList.size());
        linkedList.printStack();
    }

    public static void quickSort(int from, int to) { // 분할정복을 위해 시작, 끝점을 인자로 설정.
        int size = to - from;
        if (size == 0) return; // 부분집합의 원소가 한 개이면 종료.
        else if (size % 2 != 0) size++; // 부분집합 원소가 홀수개일 경우 가운데 원소를 pivot 지정 위해 1 키워줌.
        Node<Integer> pivot = linkedList.find(size / 2);
        Node<Integer> L = linkedList.find(from);
        Node<Integer> R = linkedList.find(to); // L 과 R 을 지정.

        boolean toggleL = false;
        boolean toggleR = false; // pivot 보다 크고 작은 원소를 찾았는지 아닌지 찾는 스위치 생성.

        while (L != R) { // L 과 R 이 만나기 전까지 진행.
            System.out.println(L.getItem());
            System.out.println(R.getItem());
            if ((int) L.getItem() > (int) pivot.getItem() && !toggleL) { // wrapper Integer 클래스이므로 형변환이 필요
                // L 값을 찾지 못한 경우에만 연산을 시행한다.
                toggleL = true; // pivot 보다 큰 값을 찾았다면 toggleL ON
            }
            if ((int) R.getItem() < (int) pivot.getItem() && !toggleR) { // pivot 보다 작은 값을 찾았다면 toggleR ON
                // R 값을 찾지 못한 경우에만 연산을 시행한다.
                toggleR = true;
            }
            if (toggleL && toggleR) { // L R 모두 pivot 보다 크고 작은 값을 찾았다면 값을 교환.
                linkedList.exchangeValue(L, R);
                toggleL = false;
                toggleR = false; // 교환이 일어난 경우, 탐색을 계속해야 하므로 스위치를 내려준다.
            }

            if (!toggleL) L = linkedList.find(from++ + 1); // pivot 보다 큰 원소를 찾지 못했을 경우 한 칸 이동.
            if (L == R) break; // L 과 R 이 바로 옆인 경우 서로 한 칸씩 이동하면 엇갈릴 수 있다. 이럴 경우 break.
            if (!toggleR) R = linkedList.find(to-- - 1); // pivot 보다 작은 원소를 찾지 못했을 경우 한 칸 이동.
        }
        if (toggleL) linkedList.exchangeValue(L, pivot);
        if (toggleR) linkedList.exchangeValue(R, pivot);
    }
}
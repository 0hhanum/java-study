// find() 메서드 생성. exchangeValue() 메서드 생성. findIndex 메서드 생성.
/*
L 은 크거나 같은 => 피봇까지 가면 멈출 수밖에 없음
R 은 작은 => 피봇을 넘어갈 수 있음
=> 그래서 L 과 R 이 만나면 피봇과 R 의 원소를 교환. => 이게 포인트임.

하 L 한칸 R 한칸씩 이동하는게 아니다. L 이 쭉 돌면서 찾고, 끝나면 R 이 움직이는거.
 */

public class Assignment_QuickSort {
    static LinkedList<Integer> linkedList = LinkedList.createTenSizeList();
    // 클래스 변수로 메서드 밖에 리스트를 생성.

    public static void main(String[] args) {

        System.out.println("=======================");
        quickSort(1, linkedList.size()); // 정렬 시행.
        System.out.println("=======================");

        System.out.print("\n정렬 결과 > ");
        linkedList.printStack();
    }

    public static void quickSort(int from, int to) { // 분할정복을 위해 시작, 끝점을 인자로 설정.
        int tmpFrom = from;
        int tmpTo = to; // from 과 to 부터 1칸씩 이동하며 탐색 후, 재귀로 from to 를 다시 호출해야 하기 때문에 값을 복사해 진행.
        int size = to - from ;

        if (size <= 0) return; // 부분집합의 원소가 한 개이거나 없으면 종료. (확정된 원소가 서로 붙어있을 때는 부분집합의 원소가 없다.)

        Node<Integer> pivot = linkedList.find(from + (size / 2)); // 부분집합의 가운데 원소를 pivot 으로 지정한다.
        Node<Integer> L = linkedList.find(from);
        Node<Integer> R = linkedList.find(to); // L 과 R 을 지정.
        boolean toggleL = false;
        boolean toggleR = false; // pivot 보다 크고 작은 원소를 찾았는지 아닌지 찾는 스위치 생성.

        while (L != R) { // L 과 R 이 만나기 전까지 반복진행.
            while (true) { // L 을 찾을 때까지 수행.
                if (L.getItem() >= pivot.getItem()) { // 해당하는 원소를 찾는다면 스위치를 켜고 탈출.
                    toggleL = true;
                    break;
                }
                else L = linkedList.find(tmpFrom++ + 1); // 한 칸씩 오른쪽으로 이동하며 탐색 수행.
                if (L == R) break; // 둘이 만난다면 탈출.
            }
            while (true) {
                if (R.getItem() < pivot.getItem()) { // 해당하는 원소를 찾는다면 스위치를 켜고 탈출.
                    toggleR = true;
                    break;
                }
                else if(L != R) R = linkedList.find(tmpTo-- - 1); // 한 칸씩 왼쪽으로 이동하며 탐색 수행. 이 때 위의 L 이동에서 R 과 겹쳤다면 이동하지 않고 종료한다.
                if(L == R) break; // 둘이 만난다면 탈출.
            }
            if (toggleL && toggleR) {
                linkedList.exchangeValue(L, R);
                if(L == pivot) pivot = R; // 만약 L 이 피봇인 경우, 피봇의 위치교환이 일어난 것이므로 변수 pivot 도 재 지정이 필요함.
                toggleL = false;
                toggleR = false; // 교환이 일어난 경우, 탐색을 계속해야 하므로 스위치를 내려준다.
            }
        }
        /*
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
        */

        // 변경이 끝나면 피봇과 R 의 원소를 교환해준다.

        linkedList.exchangeValue(R, pivot);
        pivot = R; // 값을 교환했으므로 피봇의 위치 재 지정.
        int pivotIndex = linkedList.findIndex(pivot);
        System.out.print("중간 수행 결과 > ");
        linkedList.printStack();
        System.out.println("현재 피봇: " + pivot.getItem());

        // pivot 을 기준으로 두 부분집합으로 나누어 정렬을 재귀 진행한다.
        quickSort(from, pivotIndex - 1);
        quickSort(pivotIndex + 1, to);
    }
}

// 22 31 8 16 2 30 10 69
// 10 3 482 319 12 3 4 5 1 7
// 10 9 2 3 4 581 385 3 49 20
// 10 7 6 1 3 5 3 2 100 43 23
package Assignment;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment4_2 {
    public static void main(String[] args){
        int len = 20;
        int[] list = new int[len];
        for(int i=0; i < len; i++){
            list[i] = (int) Math.pow(2, i); // 2의 제곱수를 넣어준다.
        }
        System.out.println("> 크기 20의 리스트 생성 ::");
        System.out.println(Arrays.toString(list));

        Scanner scanner = new Scanner(System.in);
        System.out.print("> 찾을 숫자를 입력하세요  : ");
        int target = scanner.nextInt();
        scanner.close();

        int head = 0;
        int tail = 19;
        int middle = (tail - head) / 2; // middle 은 head 와 tail 의 가운데값.
        boolean find = true;

        while (list[middle] != target){ // target 과 middle 이 같지 않을 동안 반복한다.
            System.out.println();
            System.out.println("현재 head index: " + head);
            System.out.println("현재 tail index: " + tail);
            System.out.println("현재 middle index: " + middle);

            if (head == tail | head > tail){ // 남은 항목이 없으면 탐색 실패. head > tail 이 되는 경우도 남는 항목이 없다.
                System.out.println("> 탐색 실패");
                find = false; // find 를 꺼준다.
                break;
            }
            if(list[middle] > target){
                // 앞부분을 재탐색.
                System.out.println(list[middle] + " 은 " + target + " 보다 큽니다. ");
                tail = middle - 1; // tail 을 middle - 1 로 설정해 middle 을 재설정한다.
                middle = head + (tail - head) / 2;
            } else {
                // 뒷부분을 재탐색.
                System.out.println(list[middle] + " 은 " + target + " 보다 작습니다. ");
                head = middle + 1; // head 을 middle + 1 로 설정해 middle 을 재설정한다.
                middle = head + (tail - head) / 2;
            }
        }
        //
        if(find) System.out.println("성공! " + target + " 이 리스트에 존재.");
        // find 가 켜진 상태로 반복문을 탈출했으면 탐색 성공.
    }
}

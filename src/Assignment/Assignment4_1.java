package Assignment;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment4_1 {
    // 2017110523 오한음 과제 4-1
    // 배열을 이용했다.
    public static void main(String[] args){
        Random random = new Random();
        int listSize = random.nextInt(100) + 1;
        int[] list = new int[listSize]; // 랜덤 크기의 배열 생성

        // 랜덤 개수만큼 배열을 채운다. 이때 한 자리는 target 을 위해 남겨둬야 하므로 크기 n 의 배열이라면 1~n-1 사이의 정수를 택한다.
        int dataSize = random.nextInt(listSize - 1) + 1;
        System.out.println("> 크기 " + listSize + "의 리스트 생성");
        System.out.println("> " + dataSize + " 개의 원소가 들어감");

        for(int i=0; i < dataSize; i++){
            int rand = random.nextInt();
            // int 형의 난수를 얻는다.
            if (rand <= 0){ // 음수 혹은 0이면 양수로 바꿔준다.
                rand = rand * (-1) + 1;
            }
            list[i] = rand; // 얻은 양의 정수를 list 에 넣는다.
        }

        System.out.println("> 생성된 리스트 ::");
        System.out.println(Arrays.toString(list));

        ////// 개선된 순차탐색 ///////
        Scanner scanner = new Scanner(System.in);
        System.out.print("> 찾으려는 양의 정수를 입력하세요  : ");
        int target = scanner.nextInt();
        scanner.close();

        list[dataSize] = target; // 리스트의 마지막에 찾으려는 정수를 집어넣는다.

        int index = 0;
        // index 를 0 부터 늘려가며 target 과 비교를 실시. while 문 내부로 진입하였다면 index 번째의 원소가 target 이 아니라는 뜻.
        while(list[index] != target){
            System.out.println("" + index + " 번째 원소 " + list[index] + " 는 " + target + " 이 아닙니다.");
            index ++;
        }
        if(index != dataSize) System.out.println("성공! " + index + " 번째에 위치합니다.");
        else System.out.println("실패");
    }
}

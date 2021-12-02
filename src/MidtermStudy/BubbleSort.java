package MidtermStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args){
        // 버블 정렬
        // 제일 뒤에서부터 높은 순으로 정렬됨.

        Scanner scanner = new Scanner(System.in);
        System.out.print("총 원소 개수 입력 > ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i=0; i<length; i++){
            System.out.println("원소 입력 (한 원소당 한 번씩 엔터) > ");
            array[i] = scanner.nextInt();
        }
        System.out.println("입력된 배열 : " + Arrays.toString(array));

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length - i - 1;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        System.out.println("정렬된 배열 : " + Arrays.toString(array));
    }
}

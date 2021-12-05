package MidtermStudy;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args){
        // 병합 정렬

        Scanner scanner = new Scanner(System.in);
        System.out.print("총 원소 개수 입력 > ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        int[] result = new int[array.length];

        for (int i=0; i<length; i++){
            System.out.println("원소 입력 (한 원소당 한 번씩 엔터) > ");
            array[i] = scanner.nextInt();
        }
        System.out.println("입력된 배열 : " + Arrays.toString(array));

        sort(array, 0, array.length - 1, result);
        System.out.println("정렬된 배열 : " + Arrays.toString(result));

    }

    public static void sort(int[] array, int from, int to, int[] result){
        if (to > from){
            int middle = (to + from) / 2;
             sort(array, from, middle, result);
             sort(array, middle + 1, to, result);
             merge(array, from, middle, to, result);
        }
    }
    public static void merge(int[] array, int from, int middle, int to, int[] result) {
        int i = from; // 첫 번째 부분집합의 첫 번째 인덱스
        int j = middle + 1; // 두 번째 부분집합의 첫 번째 인덱스
        int index = from; // 병합 후 배열의 시작 인덱스

        while (i <= middle && j <= to) {
            // 각 부분집합 별로 대소를 비교해 result 를 채워나감.
            if (array[i] <= array[j]) {
                result[index] = array[i];
                i++;
            } else {
                result[index] = array[j];
                j++;
            }
            index++;
        }
        // 첫 번째 or 두 번째 남아있는 부분집합을 붙인다. -> 상위 병합 단계에서 정렬 완료되었기 때문에 그냥 붙임
        if (i > middle) {
            while (j <= to) {
                result[index] = array[j];
                j++;
                index++;
            }
        } else {
            while (i <= middle) {
                result[index] = array[i];
                i++;
                index++;
            }
        }
        // array 에 반영
        for(int loop=from; loop<= to; loop++){
            array[loop] = result[loop];
        }
        System.out.print("중간 점검: ");
        System.out.println(Arrays.toString(result));
    }
}

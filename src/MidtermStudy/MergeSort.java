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
        for (int i=0; i<length; i++){
            System.out.println("원소 입력 (한 원소당 한 번씩 엔터) > ");
            array[i] = scanner.nextInt();
        }
        System.out.println("입력된 배열 : " + Arrays.toString(array));

        array = sort(array, 0, array.length - 1);
    }

    public static int[] sort(int[] array, int from, int to){
        if (to - from >= 1){
            int middle = (to - from) / 2;
             array = sort(array, from, middle);
             array = sort(array, middle + 1, to);
             array = merge(array, from, middle, to);
        }
        return Arrays.copyOfRange(array, from, to);
    }
    public static int[] merge(int[] array, int from, int middle, int to) {
        int i = from; // 첫 번째 부분집합의 첫 번째 인덱스
        int j = middle + 1; // 두 번째 부분집합의 첫 번째 인덱스
        int k = from; // 병합 집합의 첫째 원소 설정
        int[] result = new int[to - from];

        while (i <= middle && j <= to) {
            // 각 부분집합 별로 대소를 비교해 result 를 채워나감.
            if (array[i] <= array[j]) {
                result[k] = array[i];
                i++;
            } else {
                result[k] = array[j];
                j++;
            }
            k++;
        }
        // 첫 번째 or 두 번째 남아있는 부분집합을 붙인다. -> 상위 병합 단계에서 정렬 완료되었기 때문에 그냥 붙임
        if (i > middle) {
            while (j <= to) {
                result[k] = array[j];
                j++;
                k++;
            }
        } else {
            while (i <= middle) {
                result[k] = array[i];
                i++;
                k++;
            }
        }
        return result;
    }
}

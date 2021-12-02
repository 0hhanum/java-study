package MidtermStudy;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortArray {
    public static void main(String[] args){
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
            int minIndex = i;

            for(int j=i+1; j<array.length; j++){
                if (array[minIndex] > array[j]) minIndex = j;
            }

            // 가장 작은 걸 찾았으면 교환
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }

        System.out.println("정렬 후 : " + Arrays.toString(array));
    }

}

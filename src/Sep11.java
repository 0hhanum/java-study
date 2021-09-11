import java.util.Arrays;
import java.util.Random;

public class Sep11 {
    public static void main(String[] args) {
        /*
        int[] score = {100, 88, 100, 100, 90};
        int sum = 0;
        float average = 0.5555f;
        System.out.println(average);
        for(int i: score){
            sum += i;
        }
        average = sum / (float)score.length;
        System.out.printf("합계: %d \n", sum);
        System.out.printf("평균: %f \n", sum / (float)score.length);
//        실수 값을 얻기 위해 형변환
        System.out.print(average);
    */
        /* min max value
        int[] score = {79, 99, 91, 33, 100, 55, 96};
        int min=score[0];
        int max = min;
        for(int i=1; i<score.length; i++){
            if (score[i] > max) max = score[i];
            if (score[i] < min) min = score[i];
        }
        System.out.println(""+ min+ max);

         */
        /* Shuffle
        int[] randArray = new int[10];
        for (int i=0; i<randArray.length; i++){
            randArray[i] = i;
        }
        System.out.println(Arrays.toString(randArray));
        for(int i=0; i<randArray.length; i++){

            int rand = (int)(Math.random()*10);
            int tmp = randArray[i];
            randArray[i] = randArray[rand];
            randArray[rand] = tmp;
        }
        System.out.println(Arrays.toString(randArray));
         */
        /* 정렬
        int[] nums = new int[10];
        int[] newNums = new int[10];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random() * 30);
        }
        System.out.println(Arrays.toString(nums));
        boolean done = false;
        while(!done){
            int toggle = 0;
            for(int i=0; i < nums.length - 1; i++){
                if (nums[i] > nums[i+1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    toggle = 1;
                }
            }
            if (toggle==0) done=true;
        }

        System.out.println(Arrays.toString(nums));
    }
}

         */
        // 버블정렬 알고리즘
//        int[] nums = new int[10];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int) (Math.random() * 30);
//        }
//        System.out.println(Arrays.toString(nums));
//        for (int i=0; i<nums.length-1; i++){ // 최악경우(내림차순) => n-1 번 수행
//            boolean changed = false;
//            for (int j=0; j<nums.length-1-i;j++){
//                // 한번 수행시마다 큰 값부터 뒤쪽으로 정렬됨. (조건식에서 len-1-i 로 끝자리부터 정렬해감)
//                if (nums[j]>nums[j+1]){
//                    int tmp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = tmp;
//                    changed = true;
//                }
//            }
//            if (!changed) break; // 중간에라도 더 이상 변경 발생 안하면 탈출.
//        }
//        System.out.println(Arrays.toString(nums));
//
        // 빈도수
        int[] nums = new int[10];
        int[] counter = new int[10];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*10);
        }
        System.out.println(Arrays.toString(nums));
        for(int i: nums){
            counter[i] += 1;
        }
        System.out.println(Arrays.toString(counter));
    }}

/*
### 배열의 활용
- 총합, 평균
- 최대, 최소값
- 섞기
- 임의 값으로 채우기
- 정렬
- 빈도수

```java
	// 배열 섞기

	int[] randArray = new int[10];
        for (int i=0; i<randArray.length; i++){
            randArray[i] = i;
        }
        System.out.println(Arrays.toString(randArray));
        for(int i=0; i<randArray.length; i++){
            int rand = (int)(Math.random()*10);
            int tmp = randArray[i];
            randArray[i] = randArray[rand];
            randArray[rand] = tmp;
            // 혹은 for 에 섞고싶은 횟수를 지정하고 rand 인덱스와 배열의 첫 원소를 바꾸는 걸 반복도 가능
        }
        System.out.println(Arrays.toString(randArray));
```

<br>

```java
	// 정렬

        int[] nums = new int[10];
        int[] newNums = new int[10];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random() * 30);
        }
        System.out.println(Arrays.toString(nums));
        boolean done = false;
        while(!done){
            int toggle = 0;
            for(int i=0; i < nums.length - 1; i++){
                if (nums[i] > nums[i+1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    toggle = 1;
                }
            }
            if (toggle==0) done=true;
        }

        System.out.println(Arrays.toString(nums));
    }

    // 버블정렬 알고리즘

	int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 30);
        }
        System.out.println(Arrays.toString(nums));
        for (int i=0; i<nums.length-1; i++){ // 최악경우(내림차순) => n-1 번 수행
            boolean changed = false;
            for (int j=0; j<nums.length-1-i;j++){
                // 한번 수행시마다 큰 값부터 뒤쪽으로 정렬됨. (조건식에서 len-1-i 로 끝자리부터 정렬해감)
                if (nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    changed = true;
                }
            }
            if (!changed) break; // 중간에라도 더 이상 변경 발생 안하면 탈출.
        }
        System.out.println(Arrays.toString(nums));
```



 */
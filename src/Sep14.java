import java.util.Arrays;

public class Sep14 {
    public static void main(String[] args){
//        int[] nums = new int[10];
//        for(int i=0; i<nums.length; i++){
//            nums[i] = (int)(Math.random() * 10);
//        }
//        System.out.println(Arrays.toString(nums));
//        for(int i=0;i<nums.length - 1;i++){
//            boolean finished = false;
//            int j = i;
//            while (!finished && j < 9){
//                System.out.println(Arrays.toString(nums));
//                if(nums[j] > nums[j+1]){
//                    int tmp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = tmp;
//                    j++;
//                } else {
//                    finished = true;
//                    System.out.println("finish!" + ":" + i);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        int[] nums = new int[10];
//        int[] newNums = new int[10];
//        for(int i=0; i<nums.length; i++){
//            nums[i] = (int)(Math.random() * 10);
//        }
//        System.out.println(Arrays.toString(nums));
//        for(int i=0;i<nums.length - 1;i++){
//            int rank = 0;
//            for(int j: nums){
//                if (nums[i] > j) rank++; // 배열 내 모두와 비교해 rank 얻음
//            }
//            // 같은게 2개 이상 나올 때 처리
//            if (newNums[rank] == nums[i]){ // 같은 순위라 이미 자리에 숫자가 있다면,
//                int k = 1;
//                int toggle = 0;
//                while (toggle == 0){
//                    if(newNums[rank + k] != nums[i]) { // 하나씩 올리면서 자신과 같은 수가 이미 있는지 확인(같은 순위가 3개 이상인경우)
//                        newNums[rank + k] = nums[i]; // 자기 자리를 찾았다면 값 넣고 toggle on
//                        toggle = 1;
//                    }else{
//                        k++; // 아닐경우 k 를 증가시켜 계속 확인.
//                    }
//                }
//            } else {
//                newNums[rank] = nums[i];
//            }
//        }
//        System.out.println(Arrays.toString(newNums));
//        String[] name = {"Oh", "Han", "Um"};
//        for(int i=0; i<name.length; i++){
//            System.out.println(name[i]);
//        }
//        for(String str: name){
//            System.out.println(str);
//        }
    }
}

/*
## String 배열


### String 배열의 선언과 생성

``` java
String[] name = new String[3];  // 3개의 문자열 담을 수 있는 배열 생성.
// 이 때 배열 내 default 값은 null.
```
String 클래스와 String 배열을 구분해야함.
String 클래스를 배열으로 담는 것.

<hr>

### String 배열의 초기화

int 배열과 동일.
```java
String[] name = new String[3];
name[0] = "Oh"; // name[0] = new String("Oh");
name[1] = "Han";
name[2] = "Um";

// or
String[] name = new String[]{"Oh", "han", "um"};
// or
String[] name = {"Oh", "Han", "Um"};
```

참조변수 ```name``` 도 ```int 배열``` 과 마찬가지로 실제 객체가 아닌 객체의 주소가 저장되어있다.
**특이한 점은 배열 내 원소(```name[0]```) 에도 ```String``` 객체의 주소가 저장되어 있다는 점이다.** -> String 객체는 리터럴이 아니기에 참조변수를 이용해 저장해야 하기 때문.

``` new String name = "hello";``` 이 경우에도 ```name``` 엔 "hello" 의 주소가 저장.

>즉, 참조형 배열의 경우, 배열 내에 **객체의 주소**가 저장됨.
이를 _객체 배열_ 이라고도 한다.

```java
	String[] name = {"Oh", "Han", "Um"};
        for(int i=0; i<name.length; i++){
            System.out.println(name[i]);
        }
        for(String str: name){ // 향상된 for문.
        // String 타입으로 매개변수를 지정.
            System.out.println(str);
        }
```

 */

package September;

import java.util.Arrays;

public class Sep9 {
    public static void main(String[] args){
        int[] score = new int[3];
        for(int i: score){
            System.out.println(i);
        }
        System.out.println("**");

        int[] array = new int[]{1,2,3};
        String a = Arrays.toString(array);
        System.out.println(a);
        System.out.println("**");

        int[] test = {}; // 배열 선언, 길이가 0인 배열 생성
        for(int i:test){
            System.out.println(test);
        } // 아예 출력 x
        System.out.println("**");

        int[] test1;
        test1 = new int[]{1,2,3};
        for(int i: test1){
            System.out.println(i);
        }
        System.out.println("**");

        char[] charArray = {'a', 'b', 'c'};
        for(int i:charArray){
            System.out.println(i);
        }
        System.out.println(charArray);
        System.out.println("**");
        int[] test2 = {1,2,3};
        test2 = new int[] {4,5,6};
        for(int i:test2){
            System.out.println(i);
        }
        System.out.println("**");
        int[] arr = {1,2,3};
        int[] tmp = new int[6];
        tmp = arr;
        for (int i: tmp){
            System.out.println(i);
        }
        System.out.println("**");
        char[] oldArray = {'a', 'b', 'c'};
        char[] oldArray2 = {'d', 'e'};
        char[] newArray = new char[oldArray2.length + oldArray.length];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        System.out.println(newArray);
        System.arraycopy(oldArray2, 0, newArray, oldArray.length, oldArray2.length);
        System.out.println(newArray);

    }
}

/*
## 배열
> **같은 타입**의 여러 변수를 하나의 묶음으로 다루는 것.

```java
// ex) 5개의 int 값을 저장할 수 있는 배열 선언

int[] score = new int[5];

/*
이렇게 선언 후 생성된 배열에는 default 로 0 이 들어가있다. (new 로 생성하는게 0으로 초기화한다고 생각)
 score[0] ~ [4] 까지 (길이 5로 생성하면 0부터 4까지) 값을 저장할 수 있으며, 변수 score 은 배열을 다루는 데 필요한
 참조변수일 뿐 값을 저장하기 위한 공간은 아니다.
 */
/*
```
        배열은 각 저장공간이 **연속적** 으로 배치되어 있다.

<hr>

### 배열의 선언과 생성

        원하는 타입의 변수를 선언하고, 변수 또는 타입에 배열임을 의미하는 [] 를 붙인다. 이때 [] 는 타입 뒤에 붙여도 되고, 변수이름 뒤에 붙여도 무방하다.
        ``` int[] score;```  or ```int score[];```

        #### 배열의 생성

        배열을 선언 -> 생성될 배열을 다루기 위한 **참조변수**를 위한 공간이 만들어질 뿐.
        배열을 생성해야 **값을 저장할 수 있는** 공간이 만들어짐. => 이때 값은 모두 0으로 초기화.

        ```int[] score = new int[5] ```  (배열의 길이는 0도 가능)

        좌항은 참조변수를 선언(배열을 담을 수 있는), 우항은 배열을 생성한다고 보면 되겠다. 그러니까 ```int[] score;``` 은 배열을 생성하는 게 아님.

        정확히는 '참조변수를 선언' 이 옳은 표현이겠지만, 배열을 선언한다고 한다.

<hr>

### 배열의 길이와 인덱스
        - 생성된 배열의 각 저장공간을 '배열의 요소' 라 하며, ```array[index]``` 형태로 요소에 접근.
        - 배열의 길이는 int 범위의 양의 정수(0 포함)
        - array.length 로 길이 확인, 배열은 한번 생성하면 **길이를 변경할 수 없다.**

<hr>

### 배열의 초기화
        다음과 같은 방식으로 가능

        ```java
        int[] array = new int[]{1,2,3,4,5}; // 배열 선언, 생성, 초기화 동시에 ```

// 또는

        int[] array = {1,2,3,4,5} // new int[] 를 생략할 수 있다.
// 다만 배열의 선언과 생성을 따로 하는 경우, 위와 같은 방식은 사용불가.
        int[] array;
        array = {1,2,3}; // 이렇게는 X
        array = new int[]{1,2,3,4}; // Ok

// {} 안을 비워둘 시, '길이'가 0인 배열이 생성된다.
        ```

        #### 배열의 출력
        ```java
        int[] array = {1,2,3};
        for(int i: array){
        System.out.println(i);
        } // 혹은
        for(int i=0;i<array.length;i++){
        System.out.println(array[i]);
        }
// 이런 방식으로도 가능하겠지만, 단순히 배열 내용을 출력하고자 할 때는 다음과 같은 방법도 가능.

        System.out.println(Arrays.toString(array));
// Arrays 클래스의 toString() 메소드를 이용.
        ```

        - 예외적으로 ``char`` 배열은 ``println`` 메소드로 출력 시 각 요소가 구분자 없이 그대로 출력된다.
        (다른 배열의 경우 타입@주소 가 출력)

<hr>

### 배열의 복사
        배열은 한번 생성하면 그 길이를 변경할 수 없기 때문에 더 많은 저장공간이 필요하다면 보다 큰 배열을 새로 만들고 이전 배열로부터 그 내용을 복사.

        - for문을 이용한 복사
        ```java
        int[] arr = {1,2,3};
        int[] tmp = new int[arr.length * 2];
        for(int i=0; i<arr.length; i++;){
        tmp[i] = arr[i]
        }
        arr = tmp;
// arr 은 배열이 아니라, int 배열을 가리키는 참조변수이다. 따라서 길이 6 인 tmp를 가리킬 수 있음!
// 길이는 '배열'의 길이를 말하는 것. 참조변수와는 분리해서 생각해야함.

        ```
        위의 예시에서 참조변수 arr 과 tmp 는 같은 배열 {1,2,3,0,0,0} 을 가리키게 된다. **즉, 배열 arr 과 배열 tmp 는 이름만 다를 뿐 동일한 배열.**

        전에 arr 이 가리키던 {1,2,3} 은 더 이상 사용할 수 없게 된다.

        > 배열은 참조변수를 통해서만 접근할 수 있기 때문에, 자신을 가리키는 참조변수가 없는 배열은 **JVM 의 가비지 컬렉터에 의해서 자동적으로 메모리에서 제거된다 **

        #### System.arraycopy() 를 이용한 배열의 복사
        > for문 대신 System 클래스의 arraycopy()를 사용하면 보다 간단하고 빠르게 배열을 복사할 수 있다.

        for문은 배열의 요소 하나하나에 접근해서 복사하지만, arraycopy()는 지정된 범위의 값들을 한 번에 통째로 복사.
        ** 각 요소들이 연속적으로 저장되어 있다는 배열의 특성때문에 가능.**

        ```java
        int[] oldArray = {1,2,3};
        int[] newArray = new int[6];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
// 매개변수 왼쪽부터-> 복사할 배열, 시작 인덱스, 새로운 배열, 시작 인덱스, 요소의 개수

        char[] oldArray = {'a', 'b', 'c'};
        char[] oldArray2 = {'d', 'e'};
        char[] newArray = new char[oldArray2.length + oldArray.length];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        System.out.println(newArray);
        System.arraycopy(oldArray2, 0, newArray, oldArray.length, oldArray2.length);
        System.out.println(newArray);

// char 배열 두개 합치기
        ```


        */

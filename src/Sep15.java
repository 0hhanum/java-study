public class Sep15 {
    public static void main(String[] args){
//        int a = Integer.parseInt(args[0]);
//        char operator = args[1].charAt(0);
//        int b = Integer.parseInt(args[2]);
//        int result = 0;
//        switch (operator){
//            case '+':
//                result = a + b;
//                break;
//            case 'x':
//                result = a * b;
//                break;
//        }
//        System.out.println(result);
//        int[][] score = new int[3][3];
//        score[3][3] = 1;
//        System.out.println(score[3][3]);
        int[][] matrix = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40}
        };
        int korSum = 0;
        int mathSum = 0;
        int engSum = 0;
        System.out.println("번호   국어   영어   수학   총점   평균");
        System.out.println("---------------------------------");
        for(int i=0; i<matrix.length;i++){
            int sum = 0;
            System.out.print(i + "    ");
            for(int j: matrix[i]){
                sum+=j;
                System.out.printf("%3d   ", j);
            }
            System.out.printf("%3d   %.1f\n", sum, (float)(sum/matrix[i].length));
        }
    }
}

/*
### char 배열과 String 클래스

> '문자열' 이라는 용어는 '문자를 연이어 늘어놓은 것' 을 의미하므로 문자배열인 char 배열과 같은 뜻.

그런데 자바에서 ``char`` 배열이 아닌 ``String`` 클래스를 이용해 문자열을 다루는 이유는 ``String`` 클래스가 ``char`` 배열에 **여러 가지 기능을 추가하여 확장한 것**이기 때문.

``char`` 배열과 ``String`` 클래스의 한 가지 중요한 차이는, ``String`` 객체(문자열) 은 읽을 수만 있을 뿐, 내용을 변경할 수는 없다는 것.

```java
String example = "foo";
example += "bar";
// example 의 내용이 변경되는 것 같지만, 새로운 문자열이 생성되고 example 의 주소가 새로운 문자열을 가리키도록 변함.
```

#### String 클래스의 주요 메서드
- ```charAt(index)```: 해당 인덱스에 위치하는 문자(```char``` 를 반환)
- ```length()```: 문자열의 길이를 반환
- ```substring(from, to)```: 해당 범위 내의 문자열 반환(to 는 포함되지 않음)
- ```equals(Object)```: 문자열이 ```Object``` 와 같은지 확인. 불 형으로 반환.
	대소문자 구분 안하려면 ```equalsIgnoreCase()```
- ```toCharArray()```: 문자열을 ```char``` 배열로 바꾸어 반환.


#### char 배열 <-> String 클래스

```java
char[] charArray = {'a', 'b', 'c'};
String string = new String(charArray); // char[] => String
char[] newCharArray = string.toCharArray(); // String => char[]
```

<hr>

### 커맨드 라인을 통해 입력받기

Scanner 클래스를 이용하지 않고 사용자로부터 값을 입력받는 방법.
프로그램을 실행할 때, 클래스 이름 뒤에 공백문자로 구분하여 여러 개의 문자열을 전달할 수 있다.
```java
public Static void main(String[] args){ // args라는 이름으로 문자열 배열을 받겠다는 뜻.
for(int i=0; i<args.length; i++){
	System.out.println(args[i]);
}
}
```
```
$ java Main.java hello world

=> hello
   world
```

<hr>

## 다차원 배열

### 2차원 배열의 선언과 인덱스


- 배열 선언 예시
```java
int[][] score;
int score[][];
int[] score[];

// 3차원 이상의 고차원 배열의 선언은 [] 의 개수를 차원의 수만큼 추가해 준다.
```

- 배열 생성 예시
```java
int[][] score = new int[4][3] // 4행 3열의 2차원 배열
```
- 배열 원소에 접근
```java
score[0][2] = 100; // 1행 3열에 100 을 저장.
// new int[4][3] 으로 생성하면 인덱스는 0부터 시작해 [3][2] 까지 가능하다는 점을 주의.
```

<hr>

### 2차원 배열의 초기화

2차원 배열도 {} 를 사용해 생성과 초기화가 동시에 가능. 아래는 예시

```java
int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}};
int[][] matrix = {{1,2,3}, {4,5,6}}; // new int[][] 생략 가능.
```

2차원 배열은 **배열의 배열** 로 구성되어 있다. 여러 개의 1차원 배열을 묶어서 또 하나의 배열로 만든 것.
```
위의 예시에서,
matrix[0] -> 1행을 의미. 1행은 배열 {1, 2, 3}
matrix[1] -> 2행을 의미.
정확하게는 matrix[0] 은 배열 참조변수이다. 1행 {1,2,3} 을 참조하기 위한 주소 값이 저장되어있다.

matrix 는 matrix[0] 과 matrix[1] 을 배열로 만든 것.
즉, 배열 참조변수들(matrix[0], matrix[1]) 의 배열의 참조변수이다.

따라서
matrix.length => 2
matrix[0].length => 3
```

```java
// 2차원 배열 내의 모든 요소를 1로 초기화하기

int[][] matrix = new int[4][5];
for(int i=0; i<matrix.length; i++){
	for(int j=0; j<matrix[i].length; j++){
    		matrix[i][j] = 1;
    }}

// 향상된 for문에서 틀리기 딱 좋은 부분.
int[][] matrix = {
		{1,2,3},
		{4,5,6},
		{7,8,9}
			};

for(int[] array: matrix){ // matrix 배열로 보면 각 원소는 int 가 아니고 int[] 이다. 타입 명시
	for(int i: array){ // array 는 int[] 이고 각 원소가 int.
			...

```
 */
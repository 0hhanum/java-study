import java.util.Scanner;
/* 369 게임 #1
public class Sep7 {
    public static void main(String[] args){
        for(int i=1;i<=100;i++){
            System.out.print(i);
            if(i % 10 % 3 == 0 && i % 10 != 0){
                System.out.print("짝");
            }
            if( (i / 10) % 3 ==0){
                System.out.print("짝");
            }
            System.out.println();
        }
    }
}
 */
/* 369 게임 #2
public class Sep7{
    public static void main(String[] args){
        for(int i=1;i<=100;i++){
            System.out.print(i);
            String tmp = i + "";
            for (int j=0;j<tmp.length();j++){
                if(tmp.charAt(j) == '3' || tmp.charAt(j) == '6' || tmp.charAt(j) == '9'){
                    System.out.print("짝");
                }
            }
            System.out.println();
        }
    }
}
 */
// 369 게임 #3
public class Sep7 {
    public static void main(String[] args){
        Loop1 : for(int i=1;i<=9;i++){
            for(int j=1; j<=9; j++){
                if(j==5){
//                    break Loop1;
//                    continue Loop1;
                    continue;
                }
                System.out.println(""+i+","+j);
            }
        }
    }
}


/* 9/8
### do - while 문
> while 문의 변형으로 기본 구조는 같으나 조건식과 블럭의 순서를 바꿔놓은 것. ```do-while```, 말 그대로 블럭 내 코드 수행 후 조건식을 평가한다. 최소한 한 번은 블럭 내 코드가 실행 된다는 의미.

```java
do{
// 조건식 참일 때 수행
} while(조건식);
```
<hr>
아래는 369 게임 코드인데, 조건문에 연산식을 넣은 점이 특이해서 적어본다.

```java
for(int i=1;i<=100;i++){
            int tmp = i;
//            while 조건문에서 연산을 시행하는데, i 를 직접 변경하면 for 의 조건문에 영향이 간다. 따라서 임시 변수 지정.
            System.out.print(i);
            do{
                if(tmp % 10 % 3 == 0 && tmp % 10 != 0){
                    System.out.print("짝");
                }
            } while((tmp/=10) != 0);
            System.out.println();
        }
```

<hr>

### break 문
> ```break``` 를 만나면 자신이 포함된 **가장 가까운** 반복문을 벗어난다.


### continue 문
> 반복문 내에서만 사용될 수 있으며, 반복이 진행되는 도중에 ```continue``` 문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어간다. (```continue``` 문 이후의 문장 수행 X, 다음 반복으로)

```for``` 문의 경우 증감식으로, ```while```, ```do-while``` 문의 경우 조건식으로 이동한다. 전체 반복 중에 특정 조건을 만족하는 경우를 제외하고자 할 때 유용.

### 이름 붙은 반복문
> 하나 이상의 반복문을 벗어나거나 건너뛸 수 있다.

중첩 반복문의 경우 break 로는 근접한 하나의 반복문만 벗어날 수 있다.
이때는 중첩 방복문 앞에 이름을 붙이고 break 문과 continue 문에 이름을 지정해 줌으로써 하나 이상의 반복문을 벗어나거나 반복을 건너뛸 수 있다.

```java
Loop1 : for(int i=1;i<=9;i++){
            for(int j=1; j<=9; j++){
                if(j==5){
                    break Loop1;
                    // continue Loop1;
                    // continue;
                }
                System.out.println(""+i+","+j);
            }
        }
// Loop1 을 break 했으므로 i=1, j=1,2,3,4 까지만 출력된 후 반복문이 종료.
// continue Loop1 경우 i=1, j=5 에서 i=2, j=1 로 점프.
// continue 의 경우 1, 4 후 1, 6으로 1, 5 출력이 생략.
```
 */
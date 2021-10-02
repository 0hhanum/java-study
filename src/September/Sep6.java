package September;

import java.util.Scanner;

public class Sep6 {
    public static void main(String[] args){
        int sum = 0, i = 0;

        while((sum += i ++) < 100){
            System.out.println(sum);
        }
    }
}
/*
반복문 - for, while, do-while
for 문이나 while 문에 속한 문장은 조건에 따라 한 번도 수행되지 않을 수 있지만,
do-while 문에 속한 문장은 무조건 최소한 한 번은 수행될 것이 보장.


for 문
for 문은 반복 횟수를 알고 있을 때 적합.

for 문의 구조와 수행 순서
for (초기화; 조건식; 증감식) {
// 조건식이 참일 때 수행
}

// 제일 먼저 초기화가 수행, 그 후 조건식이 거짓일 때까지 블럭 내 코드 -> 증감식을 반복한다.
// ex)
for(int i = 1; i <= 10; i++){}
for(int i=1, j=10; i<10; i++, j--){}
초기화, 조건식, 증감식은 필요하지 않으면 생략될 수 있으며, 모두 생략도 가능. 조건식이 생략된 경우는 계속 true 상태이기 때문에 무한 반복문이 된다.

향상된 for 문
jdk 1.5 부터 배열과 컬렉션에 저장된 요소에 접근할 때 편리하도록 for 문의 새로운 문법이 추가.

for(타입 변수명 : 배열 or 컬렉션){}

// 타입 변수명: 배열 or 컬렉션의 요소의 타입.
// ex)

int[] arr = {10, 20, 30};
for(int i : arr){
	System.out.println(arr);
    }

// 기존방식
	for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
    // 인덱스로 지정
    }
while 문
조건식이 true 인 동안 반복. 초기화나 증감식이 필요하지 않은 반복문에 적합. 다음과 같은 형식이다.

while(조건식){
// 조건식이 true 일 동안 반복.
}

/*
while 문은 조건식을 생략할 수 없다. 따라서
for(;;){} 와 같이 조건식을 생략해 무한 loop 를 돌리려면 while(true) 가 되어야 한다.
*/
/*
    // 이런 방식도 가능
    int i = 5;
while(i-- != 0){
// 조건문 내에 연산을 넣었다.
        System.out.print(i);
        }
*/
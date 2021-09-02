import java.util.Date;
import java.util.Scanner;
import java.io.Console;


public class Sep3 {
    public static void main(String[] args){
        Date x = new Date();
        boolean y = false;
        String z = "hello";
        char a = 's'; // String 은 "" 로, char 은 '' 로.
        final int MAX = 10;
        System.out.println(z + y);
        System.out.println(a);
        System.out.println((int)a); // 형변환
        System.out.printf("TESTING: %010d%n", MAX);
        System.out.printf("PRACTICE: %.3s", z);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // input 저장
        System.out.println(input);
    }
}
/*
변수의 종류: 기본형과 참조형
1. 기본형: 정수, 실수, 문자, 논리
    문자형 -> char (하나의 문자만 저장. 문자열을 쓰고 싶으면 String 클래스 참조형으로 선언.)
            문자열은 공백이 가능하지만 문자형은 반드시 하나의 문자가 있어야함.
    정수형 -> int byte short long (byte 는 이진수, short 는 C 와 호환위해 사용)
    실수형 -> float double (double 이 Default)
    논리형 -> boolean
2. 참조형
    기본형 외의 나머지. 파이썬의 클래스 인스턴스와 비슷한 개념인듯? 자바는 변수 생성 시 항상 자료형을 명시해야함.
    Date x = new Date(); -> Date 클래스를 참조해 변수 x 를 선언.
 */

/*
2.2 상수와 리터럴
상수 => const a 와 유사. 한 번 값을 저장하면 다른 값으로 변경할 수 없다. 키워드 final 을 이용해 선언.
상수명은 upper case 로 작성.
* 값을 변경할 수 없기에 선언과 동시에 초기화해야함. (1.6 부터 사용 전에만 초기화하게 변경. but 습관들이기)

    final int MAX_SPEED = 10;

리터럴 => 123, A 등과 같이 그 자체로 값을 의미하는 것들.
변수 => 하나의 값을 저장하기 위한 공간.
상수 => 값을 한번만 저장할 수 있는 공간

- 리터럴의 접미사
Ex) long big = 100_000_000_000L; 끝에 L 을 붙여 타입을 구분. (_ 는 있어도 없어도 무방)
Ex) long hex = 0xFFFF_FFFF_FFFF_FFFFL => 16진수를 long 타입 변수 선언 후 초기화
Ex) float pi = 3.14f; 접미사 f, F
Ex) double rate = 1.618d; d or D (double 의 경우 default 기 때문에 접미사 생략 가능)

- 문자열
특이하게 a + b 에서 한 쪽이 문자열이면 다른 쪽이 '어떤' 타입이던 결과를 문자열로 반환.
심지어 true + "hello" => "truehello"
왼쪽에서 오른쪽으로 연산 수행하기 때문에 7 + 7 + "" => "77" 이 아닌 "14"
*/
/*
2.3 형식화된 출력 printf()
format 과 흡사
System.out.printf("age: %d", age);
printf 는 \n 까지 출력되지 않음. 문자열에 %n 을 포함시켜야함.
 */
/*
2.4 화면에서 입력받기 Scanner
Console 혹은 Scanner 클래스를 이용

 */
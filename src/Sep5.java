import java.util.Scanner;
public class Sep5{
    public static void main(String[] args){
        int score;
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수 입력>");
        String tmp = scanner.nextLine();
        score = Integer.parseInt(tmp);
        System.out.println(score/10);
        switch (score/10){
            case 10:
                System.out.println("A");
                break;
            case 9: case 8:
                System.out.println("B");
                break;
            case 7: case 6:
                System.out.println("C");
                break;
            default:
                System.out.println("Good");
        }
    }
}
/*
6.1 삼항 연산자 - 조건 연산자 ? :
오른쪽에서 왼쪽으로 계산됨.
x > 0 ? 1 : (x == 0) ? 0 : -1
=> x = 3 일 경우, 오른쪽부터 계산되어 3 > 0 ? 1 : -1   =>   0 이 반환.

6.2 대입 연산자 =, op=
대입 연산자의 왼쪽 피연산자를 lvalue 오른쪽을 rvalue 라 함.
    복합 대입 연산자 op=
    대입 연산자는 다른 연산자(op) 와 결합하여 사용할 수 있다.
    i += 3 => i = i + 3
    i += 10 + j => i = i + (10 + j)
 */
/*
제어문: 프로그램의 흐름(flow) 를 바꾸는 역할을 하는 문장들. (조건문, 반복문)
1. 조건문 - if, switch
=> 주로 if 문이 사용되며, 처리할 경우의 수가 많을 때는 switch 문이 효율적 but, if 문 보다 제약이 많다.

• switch 문. 처리할 경우의 수가 많은 경우에 유용. 조건식을 먼저 계산한 다음, 일치하는 case 문으로 이동, break 만나면 switch 문 빠져나감.
• case value 와 일치한다면 그 case 문으로 진입. 진입 후에는 break 만나기 전까지는 만나는 모든 코드를 실행한다.
  즉, break 로 쳐내지 않는다면 다른 case 까지 돌게 됨.
ex)
switch(x){
case 1(x value):
    ~~;
    break;
case 2:
    ~~;
    break;
default: case 결과값이 없을 때    ~~;
}
* switch 문의 제약조건. 조건식의 결과값이 반드시 '정수' 여야한다. 따라서 case 문의 value 역시 정수. 당연히 case value 끼리 중복되어서는 안된다.
+ 정수이면서 상수여야 한다. (변수, 실수는 불가. 문자형은 정수형과 동일하므로 가능.)
** 이제는 문자열도 제약조건으로 사용 가능한 듯 하다(JDK 1.7 이후)

 */
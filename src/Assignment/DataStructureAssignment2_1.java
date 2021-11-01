package Assignment;

import java.util.Scanner;
import MidtermStudy.ArrayStack;
/*
자료구조 및 알고리즘 과제 Q-2 (스택을 이용한 후위 연산 프로그램)
2017110523 오한음
 */

public class DataStructureAssignment2_1 {
    public static void main(String[] args){
        ArrayStack<String> calculateStack = new ArrayStack<String>();
        System.out.print("Input postfix expression. Example -> 327+* >  ");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        scanner.close();
        for (String str: tmp.split("")) { // 입력받은 문자열을 각 글자별로 for 문을 돌려줌.
            try {
                Integer.parseInt(str);
                calculateStack.push(str);
                // str 에 대해 정수형 변환을 시도하고, error 발생시(문자열일시) 연산자인지 확인을 시행.
                // 정수형 변환이 성공하면 스택에 push 한다.
            } catch(NumberFormatException e) {
                char operator = str.charAt(0); // switch 문으로 처리 위해 char 형으로 형변환.
                int num1 = Integer.parseInt(calculateStack.top());
                calculateStack.pop();
                int num2 = Integer.parseInt(calculateStack.top());
                calculateStack.pop();
                // 연산 시행에 필요한 상위 두 개 숫자를 뽑은 뒤 pop() 으로 제거.

                switch (operator){
                    // 각 연산자에 맞는 연산 수행 후 스택에 push.
                    case '+':
                        calculateStack.push("" + (num1 + num2)); // 문자열로 변환해 push.
                        break;
                    case '-':
                        calculateStack.push("" + (num2 - num1)); // 순서 주의
                        break;
                    case '*':
                        calculateStack.push("" + (num2 * num1));
                        break;
                    case '/':
                        calculateStack.push("" + (num2 / num1));
                        System.out.println("나눗셈의 경우 몫만 반환됩니다.");
                        break;
                    default:
                        throw new WrongInputException();
                        // 연산기호와 숫자 외의 문자를 입력하면 프로그램 종료.
                }
            }
        }
        if (calculateStack.size() != 1) throw new WrongexpressionException();
        // 만약 연산이 끝나고 스택에 하나 이상의 요소가 남아있다면 에러 던지기.

        System.out.println(calculateStack.top()); // 최종 값 출력
    }
}

class WrongInputException extends RuntimeException{};
class WrongexpressionException extends RuntimeException{};
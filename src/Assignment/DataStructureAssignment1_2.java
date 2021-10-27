package Assignment;

import MidtermStudy.LinkedList;

import java.util.Scanner;

/*
자료구조 및 알고리즘 과제 Q-1-2 (단순 연결 리스트를 이용한 스택 구성)
2017110523 오한음
 */


/*
2017110523 오한음 5번 문제
연결리스트 스택을 이용한 괄호 검사 프로그램.
프로그램 사용 방법
1. 프로그램 실행
2. 콘솔에 괄호 입력. 이 때 공백을 사용하지 않고 괄호만 입력한다.
3-1 모든 괄호의 짝이 맞았을 경우 Yes 출력.
3-2 괄호의 짝이 맞지 않았을 경우 No 출력.
3-3 괄호가 아닌 문자를 입력했을 때 에러 Assignment.InputOnlyBracketException 출력.
3-4 순서가 다른 괄호 ex) [}, (} 등을 입력했을 때는 에러 Assignment.WrongOrderBracketException 출력.
 */

public class DataStructureAssignment1_2 {
    public static void main(String[] args){
        LinkedList<String> bracketStack = new LinkedList<String>();
        System.out.print("Input brackets. Example -> {}{(()}{}{}) >  ");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        scanner.close();
        for (String str: tmp.split("")){ // 입력받은 문자열을 각 글자별로 for 문을 돌려줌.
            if (str.equals("{") || str.equals("[") || str.equals("(")){ // 왼쪽 괄호이면 stack 에 push.
                bracketStack.push(str);
            }
            else if (str.equals("}") || str.equals("]") || str.equals(")")) {
                // 오른쪽 괄호이면 스택의 top 과 비교를 진행한다.
                String topItem = bracketStack.top();
                if (str.equals("}") && topItem.equals("{")) bracketStack.pop();
                else if (str.equals("]") && topItem.equals("[")) bracketStack.pop();
                else if (str.equals(")") && topItem.equals("(")) bracketStack.pop();
                    // 오른쪽 괄호와 top 의 왼쪽 괄호가 쌍을 이루면 pop 으로 왼쪽 괄호를 제거.
                else {
                    // 만약 잘못된 괄호가 들어왔을 경우 에러 처리.
                    throw new WrongOrderBracketException();
                }
            } else {
                // 괄호가 아닌 문자가 들어왔을 시 에러 처리.
                throw new InputOnlyBracketException();
            }
        }
        if (bracketStack.empty()) {
            // 스택이 비었다면 괄호가 모두 맞았다는 의미이므로 Yes 출력
            System.out.println("Yes");
        } else {
            // 괄호의 짝이 맞지 않아 스택이 비지 않았다면 No 출력.
            System.out.println("No");
        }
    }
}

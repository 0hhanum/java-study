import java.util.Arrays;
import java.util.Scanner;

public class MidtermStudy_InfixToPostfix {
    public static void main(String[] args){
        ArrayStack<String> stack = new ArrayStack<String>();
        StringBuilder result = new StringBuilder();
        System.out.print("Input infix expressions. > ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();

        for(String str: expression.split("")){
            try{ // str 을 int 형으로 형변환해 result 에 붙이기 시도하고, 문자형이면 catch 로 넘억마.
                result.append(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                if (str.equals("(")){ // ( 이면 push
                    stack.push(str);

                } else if(str.equals(")")) { // ) 이면 ( 나올때까지 result 에 붙인다.
                    String top = stack.top();
                    while (!top.equals("(")){
                        result.append(top);
                        stack.pop();
                        top = stack.top();
                    }
                    if(top.equals("(")) stack.pop();

                } else { // 연산자일때 처리
                    char op = str.charAt(0);
                    if(!stack.empty()) {
                        char top = stack.top().charAt(0);
                        switch (op) {
                            // 자기의 우선순위보다 낮은 연산자가 top 에 올 때까지 pop 하여 result 에 붙인 후 push
                            case '+':
                            case '-':
                                while ((top != '(') && !stack.empty()) {
                                    result.append(top);
                                    stack.pop();
                                    if(!stack.empty()) top = stack.top().charAt(0);
                                }
                            case '*':
                            case '/':
                                while ((top != '+') && (top != '-') && (top != '(') && (top != ')') && !stack.empty()) {
                                    result.append(top);
                                    stack.pop();
                                    if(!stack.empty()) top = stack.top().charAt(0);
                                }
                        }
                    }
                    stack.push(str);
                }
            }
//        System.out.println("====================");
//        System.out.println(str);
//        System.out.println(result);
//        System.out.println(Arrays.toString(stack.getStack()));
//        System.out.println("====================");
        }
        // stack 에 남은 것들을 result 에 붙여줌.
        for(int i=0; i<stack.size() + 1;i++){
            String top = stack.top();
            result.append(top);
            stack.pop();
        }
        System.out.println(result);
    }

}

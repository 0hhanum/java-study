import java.util.Scanner;

public class DataStructureAssignment1_2 {
    public static void main(String[] args){
        LinkedListStack<String> bracketStack = new LinkedListStack<String>();
        System.out.print("Input brackets. Example -> {}{(()}{}{}) >  ");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        scanner.close();
        for (String str: tmp.split("")){ // 입력받은 문자열을 각 글자별로 for 문을 돌려줌.
            if (str.equals("{") || str.equals("[") || str.equals("(")){
                bracketStack.push(str);
            }
            else if (str.equals("}") || str.equals("]") || str.equals(")")) {
                String topItem = bracketStack.top();
                if (str.equals("}") && topItem.equals("{")) bracketStack.pop();
                else if (str.equals("]") && topItem.equals("[")) bracketStack.pop();
                else if (str.equals(")") && topItem.equals("(")) bracketStack.pop();
                    // 오른쪽 괄호와 top 의 왼쪽 괄호가 쌍을 이루면 pop 으로 왼쪽 괄호를 제거.
                else {
                    throw new WrongOrderBracketException();
                }
            } else {
                throw new InputOnlyBracketException();
            }
        }
        if (bracketStack.empty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

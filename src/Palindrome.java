import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        ArrayStack<Character> stack = new ArrayStack<Character>();
        // 제네릭 이용해 만든 배열이기 때문에 Character 클래스 사용
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string to check if it is palindrome. >");
        String inputString = scanner.nextLine(); // 문자열을 입력받는다.

        int middle = inputString.length() / 2; // 문자열의 가운데 인덱스를 위한 변수 middle 선언.

        for(int i=0;i<middle;i++){
            char c = inputString.charAt(i); // 한 글자씩 쪼갠다.
            stack.push(c); // 문자열의 절반을 스택에 push.
        }
        if (inputString.length() % 2 != 0) middle++;
        // 만약 문자열의 문자 개수가 홀수라면 가운데 글자는 건너뛴다.
        for(int i=middle; i<inputString.length();i++){
            // 문자열의 끝까지 비교를 진행.
            Character c = stack.pop();
            if(c != inputString.charAt(i)){
                System.out.println("The string is not palindrome.");
                return;
                // 만약 스택에서 뽑은 문자와 비교하는 문자가 같지 않을시 반복문을 빠져나온다.
            }
        }
        // 모두 마치고 스택이 텅 비어있다면 회문이다.
        if (stack.size() == 0){
        System.out.println("The string is palindrome.");
    } else {
        System.out.println("The string is not palindrome.");
        }
    }
}

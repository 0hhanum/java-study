package Assignment;

import java.util.Scanner;

public class Assignment_Hanoi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("원반의 개수를 입력하세요. >");
        int plates = scanner.nextInt();
        System.out.println("무슨 기둥으로 옮길 것인지 입력하세요. (b or c) > ");
        char dest = scanner.next().charAt(0);
        scanner.close();
        playHanoi(plates, 'a', dest);
        System.out.println("" + countMoves(plates) + "회 이동하였습니다.");
    }

    static int countMoves(int plates){ // 하노이탑의 이동 횟수 f(n) = 2 * f(n-1) + 1 이다.
        if (plates == 1) return 1;
        else return 2 * countMoves(plates - 1) + 1;
    }

    static void printMove(int plate, char from, char to){ // 이동을 출력해주는 메서드.
        System.out.printf("원판 %d %c 에서 %c 로 옮긴다. \n", plate, from, to);
    }

    static void playHanoi(int plates, char from, char to){
        /*
        n 개의 원판을 다른 기둥으로 옮기는 하노이탑은 n-1 개의 원판을 다른 기둥에 임시적으로 옮기고
        n 번째 원판을 목적 기둥으로 옮긴 뒤, 임시적으로 옮겨놨던 n-1 개의 원판을 다시 그 위로 옮기는 방식으로 수행됩니다.
        즉, f(n) = 2 * f(n-1) + 1 로 표현할 수 있습니다.

        단순히 이동 횟수를 구하는 것이 아니라, 이동 과정을 출력해야 했기에 "어디서 출발해 어디로 가냐" 에 초점을 맞추어 설계했습니다.

        결국 하노이탑의 모든 과정이 n-1 개의 원판을 임시적으로 a -> (b or c) 로 옮긴 후 다시 (b or c) -> a 로 옮기는 과정이기에
        from 과 to 를 인자로 주어 상황에 맞게 재귀호출 했으며, 이를 삼항연산자를 이용해 가위바위보 식으로 구현했습니다.

        ex)
        b 로 옮긴다 => a 에서 출발했는가? => c 로 n-1 개를 이동. => b 로 n 번째 원판 이동 => n-1 개를 c 에서 b 로 이동.
                  => c 에서 출발했는가? => a 로 n-1 개를 이동. => b 로 n 번째 원판 이동 => n-1 개를 a 에서 b 로 이동.

         */
        if (plates == 1) {
            printMove(1, from, to);
        } else {
            if (to == 'b'){
                char tmp = from == 'c' ? 'a' : 'c';
                playHanoi(plates - 1, from, tmp);
                printMove(plates, from, to);
                playHanoi(plates - 1, tmp, to);
            } else if (to == 'c') {
                char tmp = from == 'a' ? 'b' : 'a';
                playHanoi(plates - 1, from, tmp);
                printMove(plates, from, 'c');
                playHanoi(plates - 1, tmp, to);
            } else if (to == 'a'){
                char tmp = from == 'b' ? 'c' : 'b';
                playHanoi(plates - 1, from, tmp);
                printMove(plates, from, 'a');
                playHanoi(plates - 1, tmp, to);
            }
        }
    }
}


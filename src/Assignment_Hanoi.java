import java.util.Scanner;

public class Assignment_Hanoi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("원반의 개수를 입력하세요.");
        int plates = scanner.nextInt();
        scanner.close();
        playHanoi(plates, 'a', 'c');
//        playHanoi(plates, 'a', 'b');

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


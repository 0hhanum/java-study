import java.util.Arrays;
import java.util.Scanner;

public class Sep19{
    /*
    // 2차원 좌표에 X 표시
    public static void main(String[] args){
        final int SIZE = 5;
        int x = 0, y = 0;
        char[][] board = new char [SIZE][SIZE];
        byte[][] landmineBoard = generateLandmine(SIZE);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("좌표를 입력하세요. 예시) 43 > 프로그램 종료는 00 입력.");
            String tmp = scanner.nextLine();
            if (tmp.equals("00")) break;
            x = tmp.charAt(0) - '0' - 1; // 아스키 코드 이용 char -> int 변환
            y = tmp.charAt(1) - '0' - 1;
            if (tmp.length() != 2 || x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("잘못된 입력입니다. 5*5 범위 내에서 좌표를 입력하세요.");
                continue;
            }
            if (landmineBoard[x][y] == 1){
                System.out.println("정답!");
                break;
            } else {
                board[x][y] = 'X';
            }
            System.out.println("   1  2  3  4  5");
            int row = 1;
            for(char[] charArray : board){
                System.out.print(row++ + "  ");
                for(char i : charArray){
                    System.out.print(i + "  ");
                }
                System.out.println();
            }
        }

    }
    public static byte[][] generateLandmine(int size){
        byte[][] landmineBoard = new byte[size][size];
        int mineLocationX =  (int) (Math.random() * size);
        int mineLocationY =  (int) (Math.random() * size);
        landmineBoard[mineLocationX][mineLocationY] = 1;
        return landmineBoard;
    }
    */
    /*
    public static void main(String[] args){
        // 빙고 게임
        final int SIZE = 5;
        int[][] board = new int[SIZE][SIZE];
        board = shuffleBoard(board, SIZE);
        Scanner scanner = new Scanner(System.in);
        while(true){
            for(int i=0; i<SIZE; i++){
                for(int j=0; j<SIZE; j++){
                    System.out.printf("%4d", board[i][j]);
                }
                System.out.println();
            }
            System.out.println("숫자 입력(빙고 완료시 0)  >");
            String tmp = scanner.nextLine();
            if (tmp.equals("0")) break; // 0 입력시 종료

            int num = Integer.parseInt(tmp);
            if (num > SIZE * SIZE || num < 0) {
                System.out.println("1~25 입력");
                continue;
            };
            outer:
            for(int i=0; i<SIZE; i++){
                for(int j=0; j<SIZE; j++){
                    if (board[i][j] == num) {
                        board[i][j] = 0;
                        break outer;
                    }
                }
            }
        }

    }
    public static int[][] shuffleBoard(int[][] board, int size){ // 빙고판 섞는 메서드
        int num = 1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = num++;
            } // 1 ~ size 로 행렬 초기화.
        }
        for(int i = 0; i<size; i++){
            for(int j=0; j<size; j++){
                int randX = (int) (Math.random() * size);
                int randY = (int) (Math.random() * size);
                int tmp = board[randX][randY];
                board[randX][randY] = board[i][j];
                board[i][j] = tmp;
            }
        }
        return board;
    }

     */
    /*
    public static void main(String args[]){
        // 행렬곱
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] m2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        final int m1Col = m1[0].length;
        final int m1Row = m1.length;
        final int m2Row = m2.length;
        final int m2Col = m2[0].length;
        // m1Col must equal with m2Row
        int[][] newM = new int[m1Row][m2Col];
        for(int i=0; i<m1Row; i++){
            for(int j=0; j<m2Col; j++){
                int value = 0;
                for(int k=0; k<m1Col; k++){
                    value += m1[i][k] * m2[k][j];
                }
                newM[i][j] = value;
            }
        }
        for(int[] i:newM){
            System.out.println(Arrays.toString(i));
        }
    }
    */
    public static void main(String[] args){
        String[][] words = {
                {"내 이름은?", "오한음"},
                {"지금은", "새벽두시입니다."},
                {"이 예제를 끝내고", "잘거에요."}
        };
        Scanner scanner = new Scanner(System.in);
        for (String[] word: words){
            String question = word[0];
            String answer = word[1];

            System.out.println("Q1: " + question);
            String input = scanner.nextLine();
            if ((input.equals(answer))) {
                System.out.println("정답");
            } else {
                System.out.println("땡 정답은 " + answer + " 입니다");
            }
        }
    }
}


/*
### 가변배열

자바에서 2차원 이상의 배열을 '배열의 배열' 로 처리한다는 사실을 이용하면 보다 자유로운 형태의 배열을 구성할 수 있다.
>2차원 이상의 다차원 배열을 생성할 때 전체 배열 차수 중 마지막 차수의 길이를 지정하지 않고, 추후에 각기 다른 길이의 배열을 생성함으로써 고정된 형태가 아닌 보다 유동적인 가변 배열을 구성할 수 있다.

예시를 보자.
```java
int[][] score = new int[5][3];
// 아래와 같이 표현할 수 있다.
int[][] score = new int[5][]; // 열의 길이를 지정하지 않았다.
score[0] = new int[3];
score[1] = new int[3];
...
score[4] = new int[3];
// 다차원 배열 선언 후에 배열 내 배열의 길이를 지정해 생성할 수 있다.

// 2차원 배열이란 '배열의 배열' 이기 떄문에 각 열의 길이가 다른 2차원 배열도 가능
int[][] score = new int[5][];
score[0] = new int[4];
score[1] = new int[3];
...
```

<hr>

### 다차원 배열의 활용
- 좌표에 X 표 하기
- 빙고
- 행렬의 곱셈
- 단어 맞추기

 */
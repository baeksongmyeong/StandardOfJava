package ch5;

import java.util.Scanner;

public class MultiArrEx1 {
    public static void main(String[] args) {
        
        /*-------------------------------------
        입력한 2차원 좌표의 값이 1이면 'O', 0 이면 'X' 표시
        뽑기 구현한 것
         -------------------------------------*/
        final int SIZE = 10;
        int x = 0, y = 0;

        // 10 * 10 배열 생성
        char[][] board = new char[SIZE][SIZE];
        byte[][] shipBoard = new byte[][]{
              // 1  2  3  4  5  6  7  8  9
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, // 1
                {1, 1, 1, 1, 1, 0, 1, 0, 0}, // 2
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, // 3
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, // 4
                {0, 0, 0, 0, 0, 0, 0, 0, 0}, // 5
                {1, 1, 0, 1, 0, 0, 0, 0, 0}, // 6
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, // 7
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, // 8
                {0, 0, 0, 0, 0, 1, 1, 1, 0}  // 9
        };

        // board 배열 초기화
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        // X 축, Y 축 넘버링
        for (int i = 1; i < SIZE; i++) {
            board[0][i] = board[i][0] = (char)( i + '0' ); // 0 부터 9 까지
        }
        
        // 화면입력
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("좌표를 입력하세요. (종료는 00) > ");
            String input = scanner.nextLine(); // 화면입력

            // 숫자로 변환
            if(input.length()==2){
                x = input.charAt(0) - '0';
                y = input.charAt(1) - '0';
                if(x == 0 && y == 0) break;
            }

            if(input.length()!=2 || x<=0 || x>SIZE || y<=0 || y > SIZE){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            if(board[x][y]!=' '){
                System.out.println("이미 선택한 좌표입니다.");
                continue;
            }

            // shipBoard[x-1][y-1] 의 값이 1이면, 'O' 를 board[x][y] 에 저장한다.
            board[x][y] = shipBoard[x-1][y-1] == 1 ? 'O' : 'X';

            // 배열 board 를 출력
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            
        }
    }
}

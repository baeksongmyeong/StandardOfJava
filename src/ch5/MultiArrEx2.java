package ch5;

import java.util.Scanner;

public class MultiArrEx2 {
    public static void main(String[] args) {
        /*------------------------------------
        빙고
         ------------------------------------*/
        // x, y 길이
        final int SIZE = 5;
        
        // x, y 변수
        int x = 0, y = 0, num = 0, bingoCnt = 0;

        // 빙고판 생성
        int[][] bingo = new int[SIZE][SIZE];

        // 빙고판 초기화
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bingo[i][j] = i * SIZE + j + 1; // 0 * 5 + 0 + 1 = 1, 2, 3, 4, 5 / 1 * 5 + 0 + 1 = 6, 7, 8, 9, 10
            }
        }
        
        // 빙고판 섞기
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x = (int)(Math.random() * SIZE); // ( 0.0 ~ 0.9 ) * 5 -> 0 ~ 4
                y = (int)(Math.random() * SIZE);
                int tmp = bingo[i][j];
                bingo[i][j] = bingo[x][y];
                bingo[x][y] = tmp;
            }
        }

        // 화면 입력
        Scanner scanner = new Scanner(System.in);

        // 입력받아 처리
        do{
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.printf("%2d ", bingo[i][j] );
                }
                System.out.println();
            }
            System.out.println();
            System.out.printf("1~%d의 숫자를 입력하세요. (종료:0)>", SIZE*SIZE);
            String tmp = scanner.nextLine();
            num = Integer.parseInt(tmp);
            
            // 입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0 로 표시
            outer : for (int i = 0; i < bingo.length; i++) {
                for (int j = 0; j < bingo[i].length; j++) {
                    if(num == bingo[i][j]){
                        bingo[i][j] = 0;
                        break outer;
                    }
                }
            }
            
            // 빙고가 완성된 부분이 있는지 검증
            bingoCnt = 0;


            // 1. 행 검증
            for (int i = 0; i < bingo.length; i++) {
                int rowSum = 0;
                for (int j = 0; j < bingo[i].length; j++) {
                    rowSum += bingo[i][j];
                }
                if(rowSum==0){
                    bingoCnt += 1;
                }
            }

            // 2. 열 검증
            for (int i = 0; i < SIZE; i++) {
                int colSum = 0;
                for (int j = 0; j < SIZE; j++) {
                    colSum = bingo[j][i];
                }
                if(colSum == 0){
                    bingoCnt += 1;
                }
            }

            // 3. 좌측 대각선 검증
            int sum1 = 0;
            for (int i = 0; i < SIZE; i++) {
                sum1 = bingo[i][i];
            }
            if(sum1 == 0){
                bingoCnt += 1;
            }

            // 4. 우측 대각선 검증
            int sum2 = 0;
            for (int i = 0; i < SIZE; i++) {
                sum2 += bingo[i][SIZE - 1 -i];
            }
            if(sum2 == 0){
                bingoCnt += 1;
            }

            if(bingoCnt >= 3){
                System.out.println("**** 빙고 ****");
            }

        }while(num!=0);
    }
}

package ch5;

public class ArrayEx18 {
    public static void main(String[] args) {
        
        // 2차원 배열
        int[][] score = new int[][]{
                {100, 100, 100}, // 행 데이터
                { 20,  20,  20},
                { 30,  30,  30},
                { 40,  40,  40}
        };

        int sum = 0;

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {

                // 2차원 배열 접근 배열명[][]
                System.out.printf("score[%d][%d]=%d%n", i, j, score[i][j]);
            }
        }

        for( int[] tmp : score){
            for(int i : tmp){
                sum += i;
            }
        }

        System.out.println("합계 : " + sum);
    }
}

package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bingo {
    public static void main(String[] args) {
        // 1 ~ 50 사이의 숫자
        // 중복되지 않게
        // 25 개만 저장
        Set set = new HashSet();
        int[][] board = new int[5][5];
        while (set.size() < 26) {set.add((int) (Math.random() * 46) + 1);}
        Iterator it = set.iterator();

        for (int i = 0; i < board.length; i++) { // 행
            for (int j = 0; j < board[i].length; j++) { // 열
                board[i][j] = (int) it.next();
                System.out.printf("%3d", board[i][j]);
            }
            System.out.printf("%n");
        }
    }
}

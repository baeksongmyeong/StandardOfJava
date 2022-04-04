package ch5;

import java.util.Arrays;

public class ArrayEx8 {
    public static void main(String[] args) {
        // int 배열 ball 길이 45 초기화 없음
        int[] ball = new int[45];

        // 1 -> 45 까지 순차적 입력
        for (int i = 0; i < ball.length; i++) {
            ball[i] = i + 1;
        }

        System.out.println(Arrays.toString(ball));

        int temp = 0, j = 0;

        for (int i = 0; i < 6; i++) {
            j = (int) (Math.random() * 45);
            temp = ball[i]; // 원본요소값
            ball[i] = ball[j];
            ball[j] = temp;
        }

        // 로또번호 생성
        int[] lotto = new int[6];
        System.arraycopy(ball, 0, lotto, 0, 6);
        System.out.println(Arrays.toString(ball));
        System.out.println(Arrays.toString(lotto));

    }
}

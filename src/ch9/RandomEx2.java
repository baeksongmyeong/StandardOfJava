package ch9;

import java.util.Arrays;
import java.util.Random;

public class RandomEx2 {
    public static void main(String[] args) {
        
        int[] iArr = new int[10]; // 0 ~ 9 까지의 숫자를 각 인덱스가 나타냄

        // java.util.Random 클래스의 인스턴스 생성
        Random r = new Random();

        // 100 개의 난수를 생성. 난수 범위는 0 ~ 9
        for (int i = 0; i < 100; i++) {
            iArr[r.nextInt(10)] += 1;
        }
        
        // 각 숫자별 난수 생성 건수를 출력
        for (int i = 0; i < iArr.length; i++) {
            System.out.print(i + " 의 개수 : ");
            for (int j = 0; j < iArr[i]; j++) {
                System.out.print("#");
            }
            System.out.println(" " + iArr[i]);
        }
        
    }
}

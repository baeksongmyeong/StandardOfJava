package ch5;

import java.util.Arrays;

public class ArrayEx2 {
    public static void main(String[] args) {
        // 참조변수명 iArr1 int 타입 배열 길이 10 초기화없음
        int[] iArr1 = new int[10];

        // 참조변수명 iArr2 int 타입 배열 길이 10 초기화없음
        int[] iArr2 = new int[10];

        // 참조변수명 iArr3 int 타입 배열 길이 5  초기화 100, 95, 80, 70, 60 new 연산자 사용
        int[] iArr3 = new int[]{100, 95, 80, 70, 60};

        // 참조변수명 iArr4 int 타입 배열 길이 5  초기화 100, 95, 80, 70, 60 new 연산자 미사용
        int[] iArr4 = /*new int[]*/{100, 95, 80, 70, 60};

        // 참조변수명 chArr char 타입 배열 길이 4 초기화 a, b, c, c new 연산자 사용
        char[] chArr = new char[]{'a', 'b', 'c', 'd'};

        // 참조변수명 chArr1 char 타입 배열 길이 4 초기화 a, b, c, c new 연산자 미사용
        char[] chArr1 = {'a', 'b', 'c', 'd'};

        // iArr1 을 1부터 10까지의 수를 순차적으로 채운다.
        for(int i = 0 ; i < iArr1.length ; i++) iArr1[i] = i + 1;

        // iArr2 를 1부터 10까지의 수를 무순위로 채운다. (중복가능)
        for(int i = 0 ; i < 10 ; i++) iArr2[i] = (int) (Math.random() * 10) + 1;

        // iArr1 의 모든 요소를 인덱스 순서대로 출력
        for(int i : iArr1) System.out.print(i+",");

        System.out.println();
        
        // iArr2 의 모든 요소를 String 으로 변환하여 출력
        System.out.println(Arrays.toString(iArr2));
        System.out.print("[");
        for(int i : iArr2) System.out.print(i+", ");
        System.out.println("]");
        
        // iArr 참조변수를 그대로 출력시, 배열을 나타내는 값 출력
        System.out.println(iArr2);
        
        // iArr3 의 모든 요소를 String 으로 변환하여 출력
        System.out.println(Arrays.toString(iArr3));

        // chArr 의 모든 요소를 그대로 출력 => 배열 정보가 출력되는 것이 아니라 요소들의 값이 출력된다.
        System.out.println(chArr);

        // chArr 의 모든 요소를 String 으로 변환하여 출력
        System.out.println(Arrays.toString(chArr));

    }

}

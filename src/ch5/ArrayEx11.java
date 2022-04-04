package ch5;

import java.util.Arrays;

public class ArrayEx11 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] counter = new int[10];

        // 0 ~ 9 값 설정
        for (int i = 0; i < numArr.length; i++) numArr[i] = (int) (Math.random() * 10);
        System.out.println(Arrays.toString(numArr));

        // numArr 에 있는 숫자를 인덱스에 터치하는 횟수로 산출
        for (int i = 0; i < numArr.length; i++) counter[numArr[i]]++; // counter[numArr[i]] = counter[numArr[i]] + 1

        for (int i = 0; i < counter.length; i++) System.out.println(i+"의 개수:"+counter[i]);








    }
}

package ch5;

import java.util.Arrays;

public class ArrayEx7 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        for (int i = 0; i < numArr.length; i++) numArr[i] = i + 1;
        System.out.println(Arrays.toString(numArr));

        for(int i = 0 ; i < 100 ; i++){
            int index = (int)(Math.random() * 10);
            int orgVal = numArr[0];
            numArr[0] = numArr[index];
            numArr[index] = orgVal;
        }

        System.out.println(Arrays.toString(numArr));
    }
}

package ch5;

import java.util.Arrays;

public class ArrayEx9 {
    public static void main(String[] args) {
        int[] code = { -4, -1, 3, 6, 11};
        int[] arr = new int[10];

        for(int i = 0 ; i < arr.length ; i++){
            int tmp = (int) (Math.random() * code.length); // ( 0.0 ~ 0.9 ) * 5
            System.out.println(tmp);
            arr[i] = code[tmp];
        }

        System.out.println(Arrays.toString(arr));
    }
}

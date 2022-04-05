package ch6;

import java.util.Arrays;

public class ReferenceParamEx3 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 6, 5, 4}; // int 배열

        printArr(arr);
        sortArr(arr);
        printArr(arr);
        System.out.println(sumArr(arr));

    }

    static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
        return;
    }

    static int sumArr(int[] arr){
        int sum = 0;
        for( int i : arr) sum += i;
        return sum;
    }

    static void sortArr(int[] arr){
        // 버블정렬
        for (int i = 0; i < arr.length - 1; i++) { // -1 을 한 이유는 마지막 요소 직전요소의 인덱스만 있으면 + 1로 마지막 요소를 접근할 수 있기 때문이다.
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 시작요소, 다음요소 값 비교
                // 시작요소가 크면 시작요소와 다음요소의 값을 변경
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return;
    }
}

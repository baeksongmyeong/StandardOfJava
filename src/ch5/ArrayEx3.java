package ch5;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class ArrayEx3 {
    public static void main(String[] args) {

        // int 배열, 변수명 arr, 길이 5, 초기화 없음
        int[] arr = new int[5];

        // 배열에 1 -> 5 순차 저장
        for( int i = 0 ; i < arr.length ; i++) arr[i] = i + 1;

        // 변경전 값 출력
        for(int i = 0 ; i < arr.length ; i++) System.out.println("arr[" + i + "] : " + arr[i]);

        // int 배열, 변수명 tmp, 길이 arr 의 2배, 초기화 없음
        int[] tmp = new int[arr.length * 2];
        
        // tmp 배열에 arr 배열값 복사
        for(int i = 0 ; i < arr.length ; i++) tmp[i] = arr[i];

        // arr 참조변수를 tmp 배열을 가리키도록 변경
        arr = tmp;

        // 변경후 값 출력
        for(int i = 0 ; i < arr.length ; i++) System.out.println("arr[" + i + "] : " + arr[i]);




    }
}

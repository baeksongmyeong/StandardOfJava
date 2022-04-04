package ch5;

public class ArrayEx6 {
    public static void main(String[] args) {

        // 배열
        int[] score = new int[]{ 79, 88, 91, 33, 100, 55, 95};

        // 최대값, 최소값 초기화
        int max = score[0], min = score[0];

        // 최대값, 최소값 계산
        for(int i : score){
            if( i > max) max = i;
            else if( i < min) min = i;
        }

        System.out.println("최대값:" + max);
        System.out.println("최소값:" + min);
    }
}

package ch5;

import java.util.Arrays;

public class ArrayEx10 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        for (int i = 0; i < numArr.length; i++) System.out.print(numArr[i]=(int)(Math.random() * 10)); // 대입 후 출력까지 가능하다.
        System.out.println();
        
        // 버블정렬
        
        // 모든 요소를 순차적으로 처리
        for (int i = 0; i < numArr.length - 1; i++) {
            System.out.println("i:"+i);
            boolean changed = false;
            for(int j = 0; j < numArr.length - 1 - i; j++){
                if(numArr[j] > numArr[j+1]){
                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
                    changed = true;
                }
            }
            if(!changed) break;
            System.out.println(Arrays.toString(numArr));
        }
    }
}

package ch5;

import java.util.Arrays;

public class ArrayEx14 {
    public static void main(String[] args) {
        String src = "ABCDE";
        
        // String 클래스의 length 메서드
        for (int i = 0; i < src.length(); i++) {
            
            // String 클래스의 charAt 메서드
            char ch = src.charAt(i);
            System.out.println("src.charAt[" + i + "] : " + ch);
        }
        
        // String 클래스의 toCharArray 메서드
        char[] chArr = src.toCharArray();

        // char 배열을 프린트하면 하나의 문자열처럼 나온다.
        System.out.println(chArr);
        
        // 실제 저장된 요소들 출력
        System.out.println(Arrays.toString(chArr));
    }
}

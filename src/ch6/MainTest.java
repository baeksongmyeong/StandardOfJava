package ch6;

public class MainTest {

    static long count;

    public static void main(String[] args) {
        
        // main 메서드 재귀 호출로 Stack Overflow 예외 발생시키기
        System.out.println(++count);
        main(null);
    }
}

package ch8;

/* RuntimeException 예외 클래스들이 발생할 수 있는 코드들은, 예외처리가 되어 있지 않더라고 컴파일 및 실행이 가능하다. */

public class ExceptionEx11 {
    public static void main(String[] args) {
        throw new RuntimeException();
    }
}

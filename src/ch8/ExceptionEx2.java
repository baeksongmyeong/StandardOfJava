package ch8;

/* RuntimeException 이 발생되는 예 */

public class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;
        int divide = 0;

        for (int i = 0; i < 10; i++) {
            divide = (int) (Math.random() * 10);
            System.out.print("나누는 수 : " + divide + ", ");
            result = number / divide;
            System.out.println("결과 : " + result);
        }
    }
}

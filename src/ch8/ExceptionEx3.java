package ch8;

/* RuntimeException 이 발생할 때 이를 예외처리하는 예 */

public class ExceptionEx3 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;
        int devide = 0;

        for (int i = 0; i < 10; i++) {
            try{
                devide = (int) (Math.random() * 10);
                System.out.print("나누는 수 : " + devide + ", ");
                result = number / devide;
                System.out.println("결과 : " + result);
            }catch(ArithmeticException e){
                System.out.println("결과 : 0");
            }
        }
    }
}

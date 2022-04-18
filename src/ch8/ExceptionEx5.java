package ch8;

/* try 블록에서 예외가 발생한 경우, try 블록의 수행은 끝나며, catch 블록 안의 코드를 수행한다. catch 블록의 수행이 끝나면 try~catch 블록을 나온다. */

public class ExceptionEx5 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(1/0);
            System.out.println(4);
        } catch (ArithmeticException e){
            System.out.println(5);
        }
        System.out.println(6);
    }
}

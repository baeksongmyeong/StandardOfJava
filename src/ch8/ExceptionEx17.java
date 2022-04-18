package ch8;

/* 예외 던지기 : 예외를 try~catch 에서 처리하고나서도, 호출한 메서드에 예외를 던지는 것 */
public class ExceptionEx17 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("main 메서드에서 예외가 처리되었습니다.");
        }
    }

    static void method1() throws Exception {
        try{
            throw new Exception();
        } catch(Exception e){
            System.out.println("method1 메서드에서 예외가 처리되었습니다.");
            throw e; // 예외가 처리되었지만 처리종료하지 않고, 호출한 메서드에 던진다.
        }
    }

}

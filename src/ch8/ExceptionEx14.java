package ch8;

/* throw 한 예외 인스턴스를 받은 메서드는 이를 try~catch 로 처리하거나, 다시 throw 해야 한다. */

public class ExceptionEx14 {
    public static void main(String[] args) {
        try{
            method1();
        } catch (Exception e){}
    }

    static void method1() throws Exception {
        throw new Exception();
    }
}

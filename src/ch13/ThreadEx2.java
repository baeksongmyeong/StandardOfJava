package ch13;

/*
* 쓰레드를 생성하면, 이 쓰레드가 작업을 진행할 호출스택이 생성된다
* 쓰레드가 작업을 마치면 호출스택에 쌓여있는 메서드 호출내역이 모두 사라지는 것이며, 쓰레드를 위해 생성되었던 호출스택도 제거된다.
* 이 예제는 main() 메서드의 호출스택과 쓰레드의 호출스택이 다르다는것을 보여주기 위해, 쓰레드 실행시 예외를 발생시켜, 호출스택의 내용을 보여준 것이다.
* 결과를 보면, main() 메서드는 나오지 않고, run() 메서드가 첫번째로 쌓인 메서드로 나오는 것을 확인할 수 있다.
*
* 하나의 프로세스에서 여러 쓰레드가 있는 경우, 하나의 쓰레드에 예외가 발생하더라도, 다른 쓰레드들은 문제없이 작업을 처리한다.
* main() 메서드의 출력을 쓰레드 실행 후 예외 발생 시점 이후에 작성했는데, 지장없이 출력이 되었다.
*
* 메인 쓰레드 : main 메서드의 작업을 담당하는 쓰레드
* 
* */

// Thread 클래스를 상속받은 ThreadEx2_1 클래스 선언
class ThreadEx2_1 extends Thread {
    @Override
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t = new ThreadEx2_1();
        t.start();

        System.out.println("메인 쓰레드 종료");
    }
}

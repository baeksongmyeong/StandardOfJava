package ch13;

/*
* 쓰레드 클래스를 선언 및 인스턴스화 하는 방법
*
*   1. Thread 클래스를 상속받는 경우
*       1. run() 메서드를 오버라이드
*           - class ThreadEx1_1 extends Thread { @Override public void run(){ // 코드작성 }
*       2. 해당 클래스의 인스턴스 생성
*           - ThreadEx1_1 t1 = new ThreadEx1_1();
*       3. 인스턴스의 start() 메서드 호출 -> run() 메서드가 OS 스케쥴러 상에서 차례가 되었을때 자동으로 호출된다.
*           - t1.start();
*
*
*   2. Runnable 인터페이스를 구현하는 경우
*       1.  run() 추상메서드를 구현
*           - class ThreadEx1_2 implements Runnable { public void run(){ // 코드작성 }
*       2. 해당 클래스의 인스턴스 생성. 참조타입은 Runnable 로 한다.
*           - Runnable r = new ThreadEx1_2();
*       3. Thread 클래스의 인스턴스를 생성하며, 생성자의 인자값으로 생성된 인스턴스를 설정
*           - Thread t2 = new Thread(r);
*       4. Thread 인스턴스의 start() 메서드 호출 -> run() 메서드가 OS 스케쥴러 상에서 차례가 되었을때 자동으로 호출된다.
*           - t2.start()
*
* start() 가 호출되어 작업이 종료된 쓰레드는 다시 start() 를 호출할 수 없다. (쓰레드 인스턴스는 1회성)
*
* */

// Thread 클래스를 상속받아 쓰레드가 적용된 클래스 ThreadEx1_1 선언
class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {System.out.println(this.getName());}
    }
}

// Runnable 인터페이스를 구현하여 쓰레드가 적용된 클래스 ThreadEx1_2 선언
class ThreadEx1_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {System.out.println(Thread.currentThread().getName());}
    }
}

public class ThreadEx1 {
    public static void main(String[] args) {

        // Thread 클래스를 상속받은 클래스의 인스턴스 생성
        new ThreadEx1_1().start();

        // Runnable 인터페이스를 구현한 클래스의 인스턴스 생성
        // Runnable 타입 인스턴스 생성 -> Thread 인스턴스 생성(생성자 인자로 Runnable 타입 인스턴스 부여)
        new Thread(new ThreadEx1_2()).start();

        // 각 쓰레드를 실행
    }
}


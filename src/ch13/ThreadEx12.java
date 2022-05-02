package ch13;

/*
* 쓰레드는 아래 이유로 프로그래밍이 까다롭다
*   1. 프로세스 자원을 낭비없이 쓰레드들이 사용하기 위한 스케쥴링
*   2. 동기화
*
* 여기서는 sleep() 메서드에 대해 배운다.
*   sleep(밀리세컨드, 나노세컨드) : 지정된 시간만큼 쓰레드를 멈추게 한다.
*       - 현재 실행중인 쓰레드에 영향을 준다.
*       - 특정 쓰레드를 지정해서 sleep() 메서드를 호출해도, 현재 실행중인 쓰레드에만 영향을 준다.
*
* 아래 예는 특정 쓰레드에 sleep() 메서드를 적용해보려 했으나, 실제로는 현재 실행중인 main 메서드에 sleep() 메서드가 적용된 예이다.
* */
public class ThreadEx12 {
    public static void main(String[] args) {
        // main 쓰레드는 이미 생성되었음

        // 2개 쓰레드 생성
        ThreadEx12_1 t1 = new ThreadEx12_1();
        ThreadEx12_2 t2 = new ThreadEx12_2();

        // 2개 쓰레드를 실행대기열에 추가
        t1.start();
        t2.start();

        // t1 쓰레드를 2초동안 정지시키고 싶으나, main 쓰레드가 정지되어 버린다.
//        try {
//            t1.sleep(2 * 1000); // 자동완성에서 sleep() 메서드가 지원되지 않는다. 인스턴스를 통해 메서드 접근을 하지 말라는 의미로 보인다.
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.printf("%n<< main - %s 쓰레드 그룹의 %s 쓰레드 종료 >>%n", Thread.currentThread().getThreadGroup().getName(), Thread.currentThread().getName());
    }
}

class ThreadEx12_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", "-");
        }

        // 멈추려는 쓰레드의 본체에서 sleep() 메서드를 호출해야 한다.
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%n<< t1 - %s 쓰레드 그룹의 %s 쓰레드 종료 >>%n", Thread.currentThread().getThreadGroup().getName(), Thread.currentThread().getName());
    }
}

class ThreadEx12_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", "|");
        }
        System.out.printf("%n<< t2 - %s 쓰레드 그룹의 %s 쓰레드 종료 >>%n", Thread.currentThread().getThreadGroup().getName(), Thread.currentThread().getName());
    }
}
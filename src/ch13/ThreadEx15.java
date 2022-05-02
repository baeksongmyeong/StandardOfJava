package ch13;

/*
* Deprecate 된 메서드들
* 1. suspend() : 쓰레드를 멈춘다.
* 2. resume() : suspend() 메서드에 의해 멈춰진 쓰레드를 실행대기상태로 변경한다.
* 3. stop() : 쓰레드를 즉시 멈춘다.
*
* */
public class ThreadEx15 {
    public static void main(String[] args) {
        // Runnable 인터페이스 구현 클래스의 인스턴스 생성
        Runnable r = new RunImplEx15();

        // Runnable 구현 인스턴스로 쓰레드 생성 및 각 쓰레드에 이름 부여
        Thread th1 = new Thread(r, "*");
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");

        // 각 쓰레드를 실행대기열에 추가
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2 * 1000); // 메인 쓰레드 2초 정지

            th1.suspend();

            Thread.sleep(2 * 1000); // 메인 쓰레드 2초 정지

            th2.suspend();

            Thread.sleep(3 * 1000); // 메인 쓰레드 3초 정지

            th1.resume();

            Thread.sleep(3 * 1000); // 메인 쓰레드 3초 정지

            th1.stop();
            th2.stop();

            Thread.sleep(2 * 1000); // 메인 쓰레드 2초 정지

            th3.stop();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunImplEx15 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
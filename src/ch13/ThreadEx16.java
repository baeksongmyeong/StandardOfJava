package ch13;

/*
* Deprecate 된 메서드 사용시 교착상태에 빠질기 쉬우므로 쓰레드를 구현한 클래스에 인스턴스 변수를 추가하여
* 현재 상태를 관리하고, 작업을 진행할 수 있게 변경한 예제
* 
* */
public class ThreadEx16 {
    public static void main(String[] args) {
        RunImplEx16 r1 = new RunImplEx16();
        RunImplEx16 r2 = new RunImplEx16();
        RunImplEx16 r3 = new RunImplEx16();

        Thread th1 = new Thread(r1, "*");
        Thread th2 = new Thread(r2, "**");
        Thread th3 = new Thread(r3, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            r1.suspended();
            Thread.sleep(2000);
            r2.suspended();
            Thread.sleep(3000);
            r1.resume();
            Thread.sleep(3000);
            r1.stop();
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunImplEx16 implements Runnable {

    // deprecate 된 메서드 사용시 교착상태에 빠질수 있음
    // 이를 방지하기 위해 인스턴스 변수를 추가
    // 이 변수들이 쓰레드의 멤버 변수를 대체하게 되는건가?
    volatile boolean suspended = false;
    volatile boolean stopped = false;

    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stopped");
    }

    public void suspended() {suspended = true;}
    public void resume() {suspended = false;}
    public void stop() {stopped = true;}
}

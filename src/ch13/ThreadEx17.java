package ch13;

public class ThreadEx17 {
    public static void main(String[] args) {

        RunImplEx17 th1 = new RunImplEx17("*");
        RunImplEx17 th2 = new RunImplEx17("**");
        RunImplEx17 th3 = new RunImplEx17("***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2 * 1000);
            th1.suspend();

            Thread.sleep(2 * 1000);
            th2.suspend();

            Thread.sleep(3 * 1000);
            th1.resume();

            Thread.sleep(3 * 1000);
            th1.stop();
            th2.stop();

            Thread.sleep(2 * 1000);
            th3.stop();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class RunImplEx17 implements Runnable {

    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;

    RunImplEx17(String name) {
        th = new Thread(this, name);
    }

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

    // 쓰레드의 start() 메서드 대응 메서드
    public void start() {
        th.start();
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }

}
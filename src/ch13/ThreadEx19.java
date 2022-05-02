package ch13;

/*
* 특정쓰레드인스턴스.join() 메서드 : 현재 실행중인 쓰레드가 특정 쓰레드 인스턴스가 작업을 모두 마칠때까지 대기하게 한다.
* InterruptedException 에 대한 예외 처리가 필요하다.
* sleep() 메서드는 나 자신에 대한 대기 처리이기때문에 static 메서드이지만
* join() 메서드는 내가 아닌 다른 쓰레드를 지칭해야 하므로 인스턴스 메서드이다.
*
* */
public class ThreadEx19 {

    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx19_1 th1 = new ThreadEx19_1();
        ThreadEx19_2 th2 = new ThreadEx19_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        // 아래 join() 메서드 호출부가 없으면 main 쓰레드가 먼저 끝날수 있다. 그래서 소요시간이 먼저 나와버린다.
        try {
            // main 쓰레드가 th1, th2 쓰레드가 끝나기를 대기하도록 설정
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("소요시간 : " + (System.currentTimeMillis() - ThreadEx19.startTime));
    }
}

class ThreadEx19_1 extends Thread {
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 30; i++) {
            System.out.print(new String("-"));
            try {
                Thread.sleep(1 * 100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class ThreadEx19_2 extends Thread {
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 30; i++) {
            System.out.print(new String("|"));
            try {
                Thread.sleep(1 * 100);
            } catch (InterruptedException e) {
            }
        }
    }
}
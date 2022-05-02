package ch13;

/*
* 쓰레드가 바쁜 대기상태(스케쥴러로부터 작업시간은 할당받았으나, 처리할 대상을 기다리는 상태)에 들어가면
* 다른 쓰레드에게 자신의 작업시간을 양보하고, 자신은 대기상태로 돌아간다.
* 이렇게 하기 위해서는 yield() 메서드를 사용해야 한다.
*
* 그리고, sleep() 메서드에 의해 대기상태인 쓰레드는 interrupt() 메서드로 InterruptException 을 발생시켜, 대기상태에서 바로 빠져나와 작업을 시작하게 할 수 있다.
*
* */
public class ThreadEx18 {
    public static void main(String[] args) {
        // Runnable 인터페이스를 구현한 클래스의 인스턴스 생성 및 쓰레드 인스턴스 생성
        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");

        // 쓰레드 실행
        th1.start();
        th2.start();
        th3.start();
        
        // 각 쓰레드들을 정지, 활성화, 종료 처리
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

class ThreadEx18_1 implements Runnable {

    // 쓰레드 작업 대기 변수
    volatile boolean suspended = false;

    // 쓰레드 작업 종료 변수
    volatile boolean stopped = false;

    // 쓰레드를 참조하기 위한 변수
    Thread th;
    String thName;

    // 쓰레드를 생성하기 위한 생성자
    public ThreadEx18_1(String name) {
        this.th = new Thread(this, name);
        this.thName = name;
    }

    @Override
    public void run() {
        
        // 쓰레드 종료가 아니라면
        while (stopped == false)
        {
            // 쓰레드 정지가 아니라면
            if (suspended == false)
            {
                System.out.println(thName);
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    System.out.println(thName + " - interrupt 예외 발생");
                }
            }
            // 쓰레드 정지라면
            else {
                Thread.yield();
            }
        }
    }

    // 생성된 쓰레드를 시작시키는 메서드
    public void start() {
        th.start();
    }

    // 쓰레드를 정지 상태로 변경
    public void suspend() {
        this.suspended = true;
        th.interrupt();
        System.out.println(thName + " - suspend() 메서드가 interrupt() 호출");
    }
    
    // 쓰레드의 정지 상태를 해제
    public void resume() {
        this.suspended = false;
    }

    // 쓰레드를 종료
    public void stop() {
        this.stopped = true;
        th.interrupt();
        System.out.println(thName + " - stop() 메서드가 interrupt() 호출");
    }
}


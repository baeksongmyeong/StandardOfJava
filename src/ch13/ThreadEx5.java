package ch13;

/*
* '-' 를 출력하는 작업 - 메인 쓰레드로 처리
* '|' 를 출력하는 작업 - ThreadEx5_1 쓰레드로 처리
* 처리순서 및 처리시간을 확인
* 2개의 작업이 번갈아가며 수행된다. '-' 과 '|' 가 불규칙적으로 출력된다는 의미
* */
public class ThreadEx5 {

    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx5_1 t = new ThreadEx5_1();
        t.start();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.printf("%n소요시간1) %d", System.currentTimeMillis() - startTime);
    }
}

class ThreadEx5_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.printf("%n소요시간2) %d", System.currentTimeMillis() - ThreadEx5.startTime);
    }
}
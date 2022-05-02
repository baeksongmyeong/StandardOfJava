package ch13;

/*
* 메인 쓰레드 외에 2개의 쓰레드를 생성하여 우선순위를 조정해본다.
* 우선순위는 1~9 까지의 값을 가진다
* 값이 높을수록 보다 긴 작업시간을 할당 받을수 있다.
* 하지만 멀티코어 환경에서는 의미가 없을수 있다.
* */
public class ThreadEx8 {
    public static void main(String[] args) {

        // 메인 쓰레드에서 다른 쓰레드 생성.
        // 메인 쓰레드의 우선순위를 그대로 부여받는다. ( 5 를 부여받는다 )
        ThreadEx8_1 t1 = new ThreadEx8_1();
        ThreadEx8_2 t2 = new ThreadEx8_2();

        System.out.println("t1 우선순위 : " + t1.getPriority());
        System.out.println("t2 우선순위 : " + t2.getPriority());

        // t2 의 우선순위 변경
        t2.setPriority(7);
        System.out.println("t2 우선순위 : " + t2.getPriority());

        // 우선순위가 달라진 두 쓰레드를 실행
        t1.start();
        t2.start();
    }
}

class ThreadEx8_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int j = 0; j < 10000000; j++) {
                // 너무 빨리 끝날까봐 대기 생성
            }
        }
    }
}

class ThreadEx8_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int j = 0; j < 10000000; j++) {
                // 너무 빨리 끝날까봐 대기 생성
            }
        }
    }
}

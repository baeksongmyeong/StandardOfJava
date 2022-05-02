package ch13;

import javax.swing.*;

/*
* interrupt() 메서드 : 잠들어 있는 쓰레드를 실행대기 상태로 만든다.
*   - 쓰레드 인스턴스로 사용한다. ( sleep() 메서드는 해당 쓰레드의 클래스에 코드가 있어야 하지만 interrput() 는 아니다. )
*
* interrupted() 메서드 : 쓰레드의 상태가 interrupt() 가 호출된 상태인지 확인한 후, interrupted 상태를 false 로 초기화한다.
*
* isInterrupted() 메서드 : 쓰레드의 상태가 interrupt() 가 호출된 상태인지 확인만 하고, 초기화하지는 않는다.
* */
public class ThreadEx13 {
    public static void main(String[] args) {
        // 쓰레드 생성
        ThreadEx13_1 th1 = new ThreadEx13_1();
        // 쓰레드를 실행대기열에 추가
        th1.start();
        // 화면입력
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + " 입니다.");
        th1.interrupt();
        System.out.println("isInterrupted() : " + th1.isInterrupted());
    }
}

class ThreadEx13_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while (i != 0
                && !isInterrupted() // 인터럽트가 호출되지 않은 상태라면
        ) {
            System.out.println(i--);
            for (long j = 0; j < 2500000000L; j++) {
                // 시간지연
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

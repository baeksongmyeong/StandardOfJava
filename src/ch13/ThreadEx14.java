package ch13;

import javax.swing.*;

/*
* 쓰레드에 interrupt() 메서드가 호출된 경우, InterruptedException 이 자동 발생된다.
* 이 예외를
*   1. try ~ catch 등으로 처리하는 경우, interrupted 변수값은 true 에서 false 로 자동 초기화된다. (예외를 처리했으니 당연한 흐름)
*      인터럽트가 된 상태로 유지하고 싶다면, catch 문에서 interrupt() 메서드를 다시 호출하면 된다.
*   2. 처리하지 않은 경우, interrupted 변수값은 true 로 유지된다.
*
* */
public class ThreadEx14 {
    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + " 입니다.");
        th1.interrupt();

        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("th1.isInterrupted() : " + th1.isInterrupted());
    }
}

class ThreadEx14_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while (i != 0
                && !isInterrupted() // interrupt() 메서드가 호출되지 않았다면
        ) {
            System.out.println(i--);

            try {
                Thread.sleep(1 * 1000); // 1초 지연
            } catch (InterruptedException e) {
                System.out.println("InterruptedException 예외 발생");
                this.interrupt();
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

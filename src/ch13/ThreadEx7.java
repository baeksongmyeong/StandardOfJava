package ch13;

import javax.swing.*;

/*
* 화면을 입력하는 작업과 내부 계산을 하는 작업을 각기 다른 쓰레드에 구현
* 서로 연관이 없는 작업은 별도의 쓰레드로 처리하는 것이 나을 수 있다.
* */
public class ThreadEx7 {
    public static void main(String[] args) {
        ThreadEx7_1 t = new ThreadEx7_1();
        t.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.printf("입력하신 값은 %s 입니다.%n", input);
    }
}

class ThreadEx7_1 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.printf("%d%n", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

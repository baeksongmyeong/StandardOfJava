package ch13;

import javax.swing.*;

/*
* 화면 입력과 내부 계산을 하나의 쓰레드로 처리해 놓은 경우의 예
* 화면입력의 입력이 발생하고 처리가 끝나야, 내부 계산이 진행된다.
* 내부 계산은 화면입력과 무관한데 서로 작업의 선후관계가 생겨버렸다.
* */
public class ThreadEx6 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.printf("입력하신 값은 %s 입니다.", input);
        for (int i = 10; i > 0 ; i--) {
            System.out.printf("%d%n", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

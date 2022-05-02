package ch13;

import javax.swing.*;

public class ThreadEx20 {
    public static void main(String[] args) {
        
        // 쓰레드 인스턴스 생성
        ThreadEx20_1 gc = new ThreadEx20_1();

        // 데몬 쓰레드로 설정
        gc.setDaemon(true);

        // 데몬 쓰레드를 작업대기열에 추가
        gc.start();

        int requiredMemory = 0;

        // 데몬 프로세스를 살려두기 위한 임시방편
        //String s = JOptionPane.showInputDialog("입력하세요.");

        for (int i = 0; i < 20; i++) {
            requiredMemory = (int)(Math.random() * 10) * 20; // 0 ~ 180
            if ( gc.freeMemory() < requiredMemory // 설치하려는 용량이 남은 용량을 초과하는 경우
                    || gc.freeMemory() < gc.totalMemory() * 0.4 // 최대 용량의 40% 미만이 남은 경우
            ) {
                // 가비지 컬렉터를 깨운다. 안자고 있을수도 있지만 자고 있을 확률이 높다.
                gc.interrupt();
                try {
                    // 가비지 컬렉터 쓰레드가 작업을 진행할때, 메인 쓰레드는 가비지 컬렉터 쓰레드가 작업을 완료할 때까지 대기
                    gc.join(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory : " + gc.usedMemory);
        }
    }
}

class ThreadEx20_1 extends Thread {

    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100 * 1000); // 10 초 대기
            } catch (InterruptedException e) {
                System.out.println("Awaken by interrupt()");
            }
            gc();
            System.out.println("Garbage Collected. Free Memory : " + freeMemory());
        }
    }

    public void gc() {
        System.out.println("가비지컬렉터 실행");
        usedMemory -= 300;
        if (usedMemory < 0) {
            usedMemory = 0;
        }
    }

    public int totalMemory() {
        return MAX_MEMORY;
    }

    public int freeMemory() {
        return MAX_MEMORY - usedMemory;
    }
}

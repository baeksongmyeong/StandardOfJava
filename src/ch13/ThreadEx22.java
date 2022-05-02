package ch13;

public class ThreadEx22 {
    public static void main(String[] args) {
        // Runnable 인스턴스 생성
        RunnableEx22 r = new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class AccountSync {
    
    // 잔고
    private int balance = 1000;

    // 잔고조회
    public int getBalance() {
        return this.balance;
    }

    // 잔고 초기화
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // 출금
    // 동기화 : public synchronized void withdraw(int money) 로 선언
    public synchronized void withdraw1(int money) {
        if (this.balance >= money) {
            try {Thread.sleep(1 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            this.balance -= money;
        }
    }

    // 출금
    // 동기화 : 메서드 내부에 synchronized(자원){ } 블록 추가
    public void withdraw2(int money) {
        synchronized (this) {
            if (this.balance >= money) {
                try {Thread.sleep(1 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
                this.balance -= money;
            }
        }
    }
}

// Runnable 구현
class RunnableEx22 implements Runnable {

    // 이 Runnable 구현 인스턴스를 통해 만들어지는 쓰레드들이 공유할 자원(인스턴스)
    AccountSync acc = new AccountSync();

    @Override
    public void run() {
        
        // 잔액이 남아있는 동안 출금을 반복한다.
        
        // 메서드 선언부에 synchronized 를 선언한 메서드 호출
        while (acc.getBalance() > 0) {
            // 100, 200, 300 중 하나의 값을 만든다.
            int money = ((int) (Math.random() * 3) + 1) * 100;
            // 출금한다.
            acc.withdraw1(money);
            // 잔액을 출력한다.
            System.out.println("balance-1 : " + acc.getBalance());
        }
    }
}
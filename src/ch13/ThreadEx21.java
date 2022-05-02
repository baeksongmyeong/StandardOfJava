package ch13;


/*
* 하나의 자원을 다수의 쓰레드가 공유하게 되는 경우, 자원의 값을 읽어오는 시점에 따라 이미 처리가 끝난 데이터가 아닌, 기존 데이터를 가져오는 경우가 생긴다.
* 이를 방지하기 위해서는 메서드 선언시 synchronized 로 선언하거나, synchoronized 블럭을 선언해서 한 시점에는 하나의 쓰레드만 접근 할 수 있도록 해야 한다.
*
* */
public class ThreadEx21 {
    public static void main(String[] args) {

        // 하나의 Runnable 구현 인스턴스로 2개의 쓰레드를 생성.
        // 2개의 쓰레드는 동일한 Account 인스턴스를 참조하게 됨.
        // 이는 자원의 공유임.
        Runnable r = new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;
    public int getBalance() {return balance;}
    public void withdraw(int money) {
        String threadName = Thread.currentThread().getName();
        if (balance >= money) {
            System.out.printf("쓰레드 이름 : %s, 잔액 : %d, 출금금액 : %d%n", threadName, balance, money);
            try {Thread.sleep(1 * 1000);} catch (InterruptedException e) {}
            balance -= money;
        }
    }
}

class RunnableEx21 implements Runnable {

    Account acc = new Account();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (acc.getBalance() > 0) {
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금
            int money =  ((int)(Math.random() * 3) + 1) * 100;
            acc.withdraw(money);
            //System.out.println("balance : " + acc.getBalance());
            System.out.printf("쓰레드 이름 : %s, 출금후 잔액 : %d%n", threadName, acc.getBalance());
        }
    }
}

package ch13;

import java.util.ArrayList;

public class ThreadWaitEx1 {
    public static void main(String[] args) {
        
        // 테이블 생성
        Table table = new Table();

        // 요리사 Runnable 인스턴스 생성 및 쓰레드 생성
        new Thread(new Cook(table), "COOK1").start();

        // 도넛 손님 Runnable 인스턴스 생성 및 쓰레드 생성
        new Thread(new Customer(table, "donut"), "CUST1").start();

        // 버거 손님 Runnable 인스턴스 생성 및 쓰레드 생성
        new Thread(new Customer(table, "burger"), "CUST2").start();

        // 메인 쓰레드 0.1 초 대기
        try {Thread.sleep(1 * 100);} catch (InterruptedException e) {}
        
        // 프로세스 종료
        System.exit(0);
    }
}

// 손님
class Customer implements Runnable {

    // 손님이 앉아있는 테이블
    private Table table;
    
    // 손님이 먹을 음식
    private String food;

    // 손님을 생성할 때, 테이블과 먹을 음식도 함께 지정한다.
    public Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            // 손님 쓰레드 0.01 초 대기
            try {Thread.sleep(10);} catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();
            if (eatFood()) {
                System.out.println(name + " ate a " + food);
            } else {
                System.out.println(name + "failed to eat. : (");
            }
        }
    }

    // 지정한 음식을 먹는다.
    boolean eatFood() {return table.remove(food);}

}

// 요리사
class Cook implements Runnable {

    // 요리사에게 배정된 하나의 테이블
    private Table table;

    // 요리사를 만들때 테이블도 하나 배정
    public Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            // 임의의 요리를 하나 선택해서 테이블에 추가
            int idx = (int) (Math.random() * table.dishNum()); // 요리개수가 3개이므로 0 ~ 2 까지의 수가 반환
            table.add(table.dishNames[idx]);
            // 요리사 쓰레드 0.001 초 대기
            try {Thread.sleep(1);} catch (InterruptedException e) {}
        }
    }
}

// 테이블
class Table {

    // 음식 종류
    String[] dishNames = new String[]{"dount", "donut", "burger"};

    // 테이블당 최대 음식 개수
    final int MAX_FOOD = 6;

    // 하나의 테이블에 놓일 음식목록
    private ArrayList<String> dishes = new ArrayList<>();

    // 하나의 테이블에 음식을 추가
    public void add(String dish) {
        if (dishes.size() >= MAX_FOOD) return;
        dishes.add(dish);
        System.out.printf("Dishes : %s%n", dishes.toString());
    }

    // 하나의 테이블에서 음식을 제거
    public boolean remove(String dish) {
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).equals(dish)) {
                dishes.remove(i);
                return true;
            }
        }
        return false;
    }

    // 음식의 종류를 반환
    public int dishNum() {return dishNames.length;}
}
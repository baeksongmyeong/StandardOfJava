package ch13;

import java.util.ArrayList;

public class ThreadWaitEx3 {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();
        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"), "CUST1 - donut").start();
        new Thread(new Customer2(table, "burger"), "CUST2 - burger").start();
        //Thread.sleep(2 * 1000);
        //System.exit(0);
    }
}

//-----------------------------------
// 테이블
// - 제공 가능한 요리 종류 관리
// - 테이블 하나에 놓일수 있는 요리의 최대 개수 관리
// - 테이블에 놓인 요리들 관리
// - 특정 요리를 추가 - 요리가 가득찬 경우 wait() 호출. 요리를 추가하고 난 경우 notify() 호출
// - 특정 요리를 제거
// - 제공 가능한 요리 종류의 개수 반환
//-----------------------------------
class Table2 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    ArrayList<String> dishes = new ArrayList<>();
    public synchronized void add(String dish) {

        // 테이블에 놓인 요리의 수가 최대치라면 요리를 추가하지 않고 다른 쓰레드에게 자신에게 할당된 작업시간을 양보한다.
        // wait() 를 사용한다.
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait();
                Thread.sleep(5 * 100); // add 메서드는 요리사 쓰레드가 호출하므로, 요리사 쓰레드가 대기하게 된다.
            } catch (InterruptedException e) {
                System.out.println("음식이 꽉 차서 대기중 - InterruptedException 예외 발생");
            }
        }

        // 요리를 추가한다.
        dishes.add(dish);

        // 나 자신의 객체의 대기실에 있는 인스턴스들을 깨운다.
        // 요리를 기다리는 손님을 깨우는 것이 된다.
        notify();

        System.out.println("Dishes : " + dishes.toString());
    }

    public void remove(String dish) {
        
        // 동기화 블록 적용
        synchronized (this) {
        
            // 현재 작업이 활성화된 쓰레드의 이름
            String name = Thread.currentThread().getName();
            
            // 테이블에 요리가 없는 상태이면, 요리가 추가될 수 있도록 락을 풀고, 테이블 인스턴스의 대기실로 이동
            if (dishes.isEmpty()) {
                System.out.println(name + " is waiting.");
                try {
                    // Table 인스턴스의 Lock 을 반납하고 대기실로 이동. notify() 를 통해 깨어나게 된다.
                    wait();
                    Thread.sleep(5 * 100); // remove 는 손님 쓰레드가 호출하므로, 손님 쓰레드 2개중 하나가 대기하게 된다.
                } catch (InterruptedException e) {
                    System.out.println("음식이 하나도 없어서 대기중 - InterruptedException 예외 발생");
                }
            }
            
            // 테이블에 요리가 있는 상태이면
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    // 요리를 먹고, 잠자고 있는 요리사 쓰레드를 깨워 요리를 추가하게 한다.
                    if (dishes.get(i).equals(dish)) {
                        dishes.remove(i);
                        notify();
                        return;
                    }
                }

                // 먹으려는 음식이 없는 경우, 요리사가 음식을 추가하기를 기다린다.
                try {
                    System.out.println(name + " is waiting.");
                    wait();
                    Thread.sleep(5 * 100);
                } catch (InterruptedException e) {
                    System.out.println("먹으려는 음식 없어서 대기중 - InterruptedException 예외 발생");
                }
            }
        }
    }

    public int dishNum() {return dishNames.length;}
}

//-----------------------------------
// 요리사
//-----------------------------------
class Cook2 implements Runnable {

    private Table2 table;

    public Cook2(Table2 table) {
        this.table = table;
    }

    @Override
    public void run() {
        // 요리를 추가한다.
        while (true) {
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {Thread.sleep(1 * 100);} catch (InterruptedException e) {}
        }
    }
}

//-----------------------------------
// 손님
//-----------------------------------
class Customer2 implements Runnable {

    private Table2 table;
    private String food;

    public Customer2(Table2 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {Thread.sleep(1 * 100);} catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();
            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}
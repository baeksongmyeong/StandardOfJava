package ch13;

import java.util.ArrayList;

/*
* 음식을 제거하는 메서드에 synchronized 블록 적용
* 음식을 추가하는 메서드에 synchronized 선언부 적용
* 
* 테이블에 음식을 손님 2명이 서로 공유하며, 순서를 지켜 접근하도록 함
* 하지만, 테이블에 접근권한을 손님이 가지고 있는 경우, 요리사가 접근할 수 없어서 무한대기 상태에 빠져버림
* 
* */

public class ThreadWaitEx2 {
    public static void main(String[] args) throws Exception {

        // 테이블 인스턴스 생성
        Table1 table = new Table1();

        // 요리사 Runnable 구현 인스턴스 생성 및 쓰레드 생성
        // Table 인스턴스를 공유한다.
        // 테이블 인스턴스에 0.1초마다 요리를 추가한다.
        new Thread(new Cook1(table), "COOK1").start();

        // 손님 Runnable 구현 인스턴스 생성 및 쓰레드 생성
        // 2개의 쓰레드를 생성
        // Table 인스턴스를 공유한다.
        new Thread(new Customer1(table, "donut"), "CUST1").start();
        new Thread(new Customer1(table, "burger"), "CUST2").start();

        Thread.sleep(5 * 1000);
        System.out.println("main 쓰레드 종료");
        //System.exit(0);
    }
}

//-----------------------------------
// 테이블
//-----------------------------------
class Table1 {

    // 요리 종류
    String[] dishNames = {"donut", "donut", "burger"};

    // 요리 최대개수
    final int MAX_FOOD = 6;

    // 테이블 내 요리 놓인 것
    private ArrayList<String> dishes = new ArrayList<>();

    // 테이블에 요리 추가
    public synchronized void add(String dish) { // synchronized 를 메서드 선언부에 추가
        if (dishes.size() >= MAX_FOOD) return;
        dishes.add(dish);
        System.out.println("Dishes : " + dishes.toString());
    }

    // 테이블에 요리 제거
    public boolean remove(String dish) {
        // synchronized 블록 추가
        synchronized (this) {
            
            // 음식이 비어있으면 대기. 0.5초마다 음식이 있는지 확인
            while (dishes.size() == 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {Thread.sleep(5 * 100);} catch (InterruptedException e) {}
            }

            for (int i = 0; i < dishes.size(); i++) {
                if (dishes.get(i).equals(dish)) {
                    dishes.remove(i);
                    return true;
                }
            }
        } // synchronized 블록
        return false;
    }

    public int dishNum() {return dishNames.length;}
}

//-----------------------------------
// 요리사
//-----------------------------------
class Cook1 implements Runnable {

    private Table1 table;

    public Cook1(Table1 table) {this.table = table;}

    @Override
    public void run() {
        while (true) {
            int idx = (int)(Math.random() * table.dishNum());
            // 동기화된 메서드 호출
            table.add(table.dishNames[idx]);
            try {Thread.sleep(1 * 100);} catch (InterruptedException e) {}
        }
    }
}

//-----------------------------------
// 손님
//-----------------------------------
class Customer1 implements Runnable {

    private Table1 table;
    private String food;

    public Customer1(Table1 table, String food) {
        this.table = table;
        this.food = food;
    }

    public boolean eatFood() {return table.remove(food);}

    @Override
    public void run() {
        try {Thread.sleep(1 * 10);} catch (InterruptedException e) {}
        String name = Thread.currentThread().getName();
        if (eatFood() == true) {
            System.out.println(name + " ate a " + food);
        } else {
            System.out.println(name + " failed to eat : " + food);
        }
    }
}
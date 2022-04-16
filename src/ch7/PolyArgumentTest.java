package ch7;

/*
메서드의 매개변수에 다형성을 적용하기
 */

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer1 buyer = new Buyer1();
        buyer.buy(new Tv1());
        buyer.buy(new Computer1());
        buyer.buy(new Computer1());
        buyer.buy(new Computer1());
        buyer.buy(new Computer1());
        buyer.buy(new Computer1());
        buyer.buy(new Computer1());
    }
}

class Product1 {
    int price;
    int bounsPoint;

    public Product1(int price) {
        this.price = price;
        bounsPoint = (int) (price / 10.0);
    }
}

class Tv1 extends Product1 {
    Tv1(){ super(100); }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer1 extends Product1 {
    Computer1(){
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer1 {
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product1 p){
        if(money < p.price){
            System.out.println("잔액이 부족합니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bounsPoint;
        System.out.printf("%s 를 구입하셨습니다. 잔액은 %d, 마일리지는 %d 입니다.%n", p, this.money, this.bonusPoint);
    }
}
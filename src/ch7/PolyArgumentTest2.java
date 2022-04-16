package ch7;

import java.util.Arrays;

class Product2 {
    int price; // 가격
    int bonusPoint; // 구매시 제공되는 포인트

    Product2(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}

class Tv2 extends Product2 {
    Tv2() { super(100); }
    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer2 extends Product2 {
    Computer2(){ super(200); }
    @Override
    public String toString(){
        return "Computer";
    }
}

class Audio2 extends Product2 {
    Audio2(){ super(50); }
    public String toString(){
        return "Audio";
    }
}

class Buyer2 {
    int money; // 잔액
    int bonusPoint; // 잔여포인트
    Product2[] item = new Product2[10]; // 구매한 제품목록. 조상 타입의 배열로 자손 타입 인스턴스들의 참조변수들을 저장할 수 있다.
    int i;

    {
        money = 1000;
        bonusPoint = 0;
        i = 0;
    }

    void buy(Product2 p){
        if(this.money < p.price){
            System.out.println("잔액부족");
            return;
        }

        this.money -= p.price;
        this.bonusPoint += p.bonusPoint;
        this.item[i++] = p;
        System.out.println(p + "구입");
    }

    void summary(){
        int sum = 0;
        String itemList = "";

        System.out.println(Arrays.toString(item));

        for( Product2 p : item){
            if(null != p){
                sum += p.price;
                itemList += p.toString() + ", ";
            }
        }

        System.out.printf("총 구입금액 : %d%n", sum);
        System.out.printf("총 상품목록 : %s%n", itemList);
    }
}

public class PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer2 buyer = new Buyer2();
        buyer.buy(new Tv2());
        buyer.buy(new Computer2());
        buyer.buy(new Audio2());
        buyer.summary();
    }
}

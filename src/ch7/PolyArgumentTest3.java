package ch7;

import java.util.Vector;

class Product3 {
    int price;
    int bonusPoint;

    Product3(int price){
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}

class Tv3 extends Product3 {
    static int num = 0;
    final int code;
    Tv3(){
        super(200);
        code = num++;
    }
    @Override public String toString() {
        return "Tv" + code;
    }
}

class Computer3 extends Product3 {
    static int num = 0;
    final int code;
    Computer3(){
        super(100);
        code = num++;
    }
    @Override public String toString(){
        return "Computer" + code;
    }
}

class Audio3 extends Product3 {
    static int num = 0;
    final int code;
    Audio3(){
        super(50);
        code = num++;
    }
    @Override public String toString() {
        return "Audio" + code;
    }
}

class Buyer3 {
    int money = 1000;
    int bonusPoint = 0;
    Vector<Product3> items = new Vector<Product3>();

    void buy(Product3 item){
        if(this.money <= item.price){
            System.out.println("잔액부족");
            return;
        }
        items.add(item);
        this.money = this.money - item.price;
        this.bonusPoint = this.bonusPoint + item.bonusPoint;
        System.out.println(item + "을 구입하셨습니다.");
    }

    void refund(Product3 item){
        if(this.items.remove(item)){
            this.money = this.money + item.price;
            this.bonusPoint = this.bonusPoint - item.bonusPoint;
            System.out.println(item + "상품이 반품되었습니다.");
        }else{
            System.out.println(item +"은 구입한 상품이 아닙니다.");
        }
    }

    void summary(){
        int sum = 0;
        String itemList = "";

        for (Product3 item : items) {
            sum += item.price;
            itemList += item + ", ";
        }
        System.out.println("총 구매금액 : " + sum);
        System.out.println("총 구매상품 : " + itemList);
    }
}



public class PolyArgumentTest3 {
    public static void main(String[] args) {
        Buyer3 b = new Buyer3();
        Tv3 tv1 = new Tv3();
        Tv3 tv2 = new Tv3();
        Computer3 computer1 = new Computer3();
        Computer3 computer2 = new Computer3();
        Audio3 audio1 = new Audio3();
        Audio3 audio2 = new Audio3();

        b.buy(tv1);
        b.buy(tv2);
        b.buy(computer1);
        b.buy(computer2);
        b.buy(audio1);
        b.buy(audio2);
        System.out.println();
        b.summary();
        System.out.println();
        b.refund(computer1);
        b.summary();
        System.out.println();
        b.refund(new Tv3());
    }
}

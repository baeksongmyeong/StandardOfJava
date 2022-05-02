package ch12;

import java.util.ArrayList;

/*
* 와일드카드 '?' : 1. 클래스가 지네릭이 아니거나
*                2. 메서드가 static 인 경우
*                위 경우에 메서드의 매개변수에 지네릭스 적용 용도
*                static 메서드에는 타입변수를 쓸 수 없음.
*                따라서 다양한 타입을 매개변수로 사용해야 하는 static 메서드인 경우,
*                각 타입별로 static 메서드를 만들어야 함.
*                이를 좀 더 편하게 코딩할 수 있게 하기 위해 어떤 타입이든 될 수 있다는 의미로 ? 를 제공
* 
* 전체 : ? : 모든 클래스가 사용될 수 있음
* 하한 : ? extends A : A 클래스를 포함하며, A 클래스의 자손들이 사용될 수 있음
* 상한 : ? super A : A 클래스를 포함하며, A 클래스의 조상들이 사용될 수 있음
*
* */
public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();

        // 과일박스
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());

        // 사과박스
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());

        Juice fruitJuice = Juicer.makeJuice(fruitBox);
        Juice appleJuice = Juicer.makeJuice(appleBox);

        System.out.println("fruitJuice = " + fruitJuice);
        System.out.println("appleJuice = " + appleJuice);
    }
}

// 과일, 사과, 포도 클래스
class Fruit2 { public String toString(){return "Fruit";}}
class Apple2 extends Fruit2 { public String toString(){return "Apple";}}
class Grape2 extends Fruit2 { public String toString(){return "Grape";}}

// Box2 클래스. 리스트 가져오기 메서드 추가.
class Box2<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item){list.add(item);}
    T get(int index){return list.get(index);}
    ArrayList<T> getList(){return list;}
    int size(){return list.size();}
    public String toString(){return list.toString();}
}

// FruitBox2 는 Fruit2 와 그 자손 인스턴스만 사용할 수 있는 클래스
class FruitBox2<T extends Fruit2> extends Box2<T> {}

class Juice {
    String name;
    Juice(String name){this.name = name;}
    public String toString(){return name;}
}

class Juicer {
    // static 메서드. 타입변수 사용불가. 그래서 와일드카드를 사용. 하한을 설정.
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
        String tmp = "";
        for (Fruit2 fruit : box.getList()) {tmp += fruit.toString() + " ";}
        return new Juice(tmp + "Juice");
    }
}




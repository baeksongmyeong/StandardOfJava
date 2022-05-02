package ch12;

import java.util.ArrayList;

/*
* 지네릭스에서 사용되는 타입에 제한을 거는 방법
*   - extends 를 사용
*   - T extends 특정클래스 : 특정 클래스를 포함하여 자손 관계에 있는 클래스만 대입 가능
*   - 클래스만이 아니라, 인터페이스 구현 조건도 extends 를 사용한다.
*   - 클래스, 인터페이스를 각각 상속, 구현하는 클래스를 지정할때는 '&' 기호로 묶어준다.
*
* */
class Fruit1 implements Eatable{public String toString(){return "Fruit1";}}
class Apple1 extends Fruit1{public String toString(){return "Apple1";}}
class Grape1 extends Fruit1{public String toString(){return "Grape1";}}
class Toy1 {public String toString(){return "Toy1";}}
interface Eatable {}

// Fruit 포함. 자손 클래스들이며, Eatable 인터페이스를 구현한 클래스만 대입 가능한 지네릭 클래스 선언
class FruitBox<T extends Fruit1 & Eatable> extends Box1<T>{}

// 지네릭 클래스 Box1
class Box1<T> {
    ArrayList<T> list = new ArrayList<>();
    T get(int i){return list.get(i);}
    void add(T item){list.add(item);}
    public String toString(){return list.toString();}
}

public class FruitBoxEx2 {
    public static void main(String[] args) {
        //new FruitBox<Object>(); // Object 클래스는 Fruit 의 자손, Eatable 의 구현 인스턴스가 아니므로 제한된다.
        FruitBox<Fruit1> fruitBox = new FruitBox<>();
        FruitBox<Apple1> appleBox = new FruitBox<>();
        FruitBox<Grape1> grapeBox = new FruitBox<>();
        //new FruitBox<Toy1>(); // Toy1 클래스는 Fruit 의 자손, Eatable 의 구현 인스턴스가 아니므로 제한된다.

        fruitBox.add(new Fruit1());
        fruitBox.add(new Apple1());
        fruitBox.add(new Grape1());

        appleBox.add(new Apple1());
        //appleBox.add(new Grape1()); // Grape1 은 Apple1 의 자손이 아니므로 오류

        grapeBox.add(new Grape1());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(grapeBox);

    }
}

package ch12;

import java.util.ArrayList;

/*
* 지네릭 메서드 : 메서드의 선언부에 지네릭 타입이 선언된 메서드
*   - 선언위치는 반환타입 바로 앞
*       - public static < T extends Fruit > Juice makeJuice(FruitBox<T> box)
*   - 선언된 지네릭 타입이 메서드의 매개변수를 포함해서 메서드 모든 영역에 영향을 줌
*   - 클래스에 선언된 지네릭 타입과는 별개로 움직임
*   - 메서드 내 지역변수로 생각하면 됨. 따라서 클래스의 지네릭과 메서드의 지네릭이 중첩되는 경우, 메서드의 타입이 우선됨
*   - 메서드가 static 인 경우에도 사용할 수 있음
*   - 메서드 호출시 타입변수를 넣어줘야 하지만
*   - 대부분의 경우 컴파일러가 타입변수에 들어갈 타입을 추정할 수 있으므로, 메서드 호출시 타입변수를 생략가능
*       - Juicer.<Fruit>makeJuice(fruitBox);
*           -> Juicer.makeJuice(fruitBox);
*
* */
public class FruitBoxEx3_GenericMethod {
    public static void main(String[] args) {
        FruitBox2_2<Fruit2_2> fruitBox = new FruitBox2_2<Fruit2_2>();
        FruitBox2_2<Apple2_2> appleBox = new FruitBox2_2<Apple2_2>();

        // 과일박스
        fruitBox.add(new Apple2_2());
        fruitBox.add(new Grape2_2());

        // 사과박스
        appleBox.add(new Apple2_2());
        appleBox.add(new Apple2_2());

        // 기존 메서드 사용
        Juice_2 fruitJuice = Juicer_1.makeJuice(fruitBox);
        Juice_2 appleJuice = Juicer_1.makeJuice(appleBox);

        System.out.println("fruitJuice = " + fruitJuice);
        System.out.println("appleJuice = " + appleJuice);
        
        // 지네릭 메서드 사용
        fruitJuice = Juicer_2.<Fruit2_2>makeJuice(fruitBox);
        appleJuice = Juicer_2.<Apple2_2>makeJuice(appleBox);

        System.out.println("fruitJuice = " + fruitJuice);
        System.out.println("appleJuice = " + appleJuice);
    }

}

//-------------------------------
// 기존 메서드
//-------------------------------
class Juicer_1 {
    // static 메서드. 타입변수 사용불가. 그래서 와일드카드를 사용. 하한을 설정.
    static Juice_2 makeJuice(FruitBox2_2<? extends Fruit2_2> box) {
        String tmp = "";
        for (Fruit2_2 fruit : box.getList()) {tmp += fruit.toString() + " ";}
        return new Juice_2(tmp + "Juice");
    }
}

//-------------------------------
// 기존 메서드 -> 지네릭 메서드 변환
//-------------------------------
class Juicer_2 {
    static <T extends Fruit2_2> Juice_2 makeJuice(FruitBox2_2<T> box) {
        String tmp = "";
        for (Fruit2_2 fruit : box.getList()) {tmp += fruit.toString() + " ";}
        return new Juice_2(tmp + "Juice");
    }
}

// 과일, 사과, 포도 클래스
class Fruit2_2 { public String toString(){return "Fruit";}}
class Apple2_2 extends Fruit2_2 { public String toString(){return "Apple";}}
class Grape2_2 extends Fruit2_2 { public String toString(){return "Grape";}}

// Box2 클래스. 리스트 가져오기 메서드 추가.
class Box2_2<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item){list.add(item);}
    T get(int index){return list.get(index);}
    ArrayList<T> getList(){return list;}
    int size(){return list.size();}
    public String toString(){return list.toString();}
}

// FruitBox2 는 Fruit2 와 그 자손 인스턴스만 사용할 수 있는 클래스
class FruitBox2_2<T extends Fruit2_2> extends Box2_2<T> {}

class Juice_2 {
    String name;
    Juice_2(String name){this.name = name;}
    public String toString(){return name;}
}
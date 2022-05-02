package ch12;

import java.util.ArrayList;
import java.util.List;

/*
* 지네릭스 : 컴파일 시점에 타입의 검증을 해주는 기능
*   - 특정 타입만 사용할 수 있게 제한할 수 있다.
*   - 클래스와 메서드 각각 지네릭 타입을 설정할 수 있다.
*   - 클래스에 지네릭을 설정하는 경우
*       - static 멤버에는 적용할 수 없다.
*       - 배열 생성시 적용할 수 없다. 다만 배열 참조변수에는 적용할 수 있다.
*       - 인스턴스 생성시, 참조변수와 생성자에 대입되는 타입변수는 같은 것이어야 한다.
*       - 참조변수에 타입이 대입된 경우, 생성자에는 생략할 수 있다
*       - 참조변수와 생성자간 대입되는 타입이 동일한 경우만 다형성이 유효하다.
*       - 대입되는 타입의 인스턴스 외에도, 자손 인스턴스들을 인자로 전달할 수 있다.
* */
public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Toy> toyBox = new Box<>();
        //Box<Grape> grapeBox = new Box<Apple>(); // 참조변수와 생성자의 대입된 타입이 불일치하여 오류 발생

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        //fruitBox.add(new Toy()); Toy 클래스는 Fruit 클래스의 자손클래스가 아니므로 대입이 불가하다.

        appleBox.add(new Apple());
        //appleBox.add(new Fruit()); // Fruit 클래스는 Apple 클래스의 조상이므로 대입이 불가하다. 자손만 가능하다.

        toyBox.add(new Toy());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);

        NewBox<Fruit> fruitNewBox = new NewBox<>();
        fruitNewBox.add(new Fruit());
    }
}

class Fruit {public String toString(){return "Fruit";}}
class Apple extends Fruit {public String toString(){return "Apple";}}
class Grape extends Fruit {public String toString(){return "Grape";}}
class Toy {public String toString(){return "Toy";}}

class Box<T> {
    List<T> list = new ArrayList();
    void add(T item){list.add(item);}
    T get(int i){return list.get(i);}
    int size(){return list.size();}
    @Override public String toString(){return list.toString();}
}

class NewBox<T extends Fruit> {
    List<T> list = new ArrayList();
    void add(T item){list.add(item);}
    T get(int i){return list.get(i);}
    int size(){return list.size();}
    @Override public String toString(){return list.toString();}
}

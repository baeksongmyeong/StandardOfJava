package ch9;

import java.lang.reflect.InvocationTargetException;

/*
* Class 클래스에 대해 알아본다.
* Class 클래스는 클래스가 클래스로더에 의해 로딩될 때, 해당 클래스에 대한 정보를 담는 공간이며, 인스턴스화되어 메모리에 저장된다.
* Class 클래스의 인스턴스는 로딩된 클래스와 1 : 1 로 연결된다.
* Class 클래스의 인스턴스는 로딩된 클래스의 모든 정보를 담고 있다.
* 이를 통해서 로딩된 특정 클래스의 정보를 조회하거나, 메서드를 호출하거나, 인스턴스를 생성할 수도 있다.
* */
public class ClassEx1 {
    public static void main(String[] args) {
        
        // Class 인스턴스를 참조하는 방법 3가지
        
        // 1. 인스턴스를 통한 Class 인스턴스 조회 및 참조하기
        Card3 c1 = new Card3("HEART", 3);
        Class<? extends Card3> card1 = c1.getClass();
        
        // 2. 클래스의 리터럴을 통한 Class 인스턴스 조회 및 참조하기 
        Class<Card3> card2 = Card3.class;
        
        // 3. Class 클래스의 static 메서드인 forName() 메서드를 통한 Class 인스턴스 조회 및 참조하기
        try {
            Class<?> card3 = Class.forName("ch9.Card3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Class 클래스의 인스턴스를 통한 새로운 인스턴스 생성
        Card3 c2 = null;

        try {
            c2 = card1.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(card1.getName());
        System.out.println(card1.toGenericString());
        System.out.println(card1.toString());

    }


}

final class Card3 {
    String kind;
    int number;

    public Card3(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public Card3() {
        this("SPADE", 1);
    }

    @Override
    public String toString() {
        return kind + "," + number;
    }
}

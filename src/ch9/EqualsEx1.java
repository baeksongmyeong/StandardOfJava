package ch9;

/*
* Object 클래스의 equals() 메서드는 참조변수의 값(참조하는 인스턴스의 주소값)을 비교하여, 동일하면 true, 다르면 false 를 리턴한다.
* */

public class EqualsEx1 {

    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);
        // 인스턴스변수의 값이 동일해도, 인스턴스의 주소는 다르므로, equals() 는 false 를 반환한다.
        System.out.println(v1.equals(v2));

        // 같은 인스턴스를 참조하도록 변경
        v2 = v1;

        // 인스턴스의 주소가 동일하므로, equals() 는 true 를 반환한다.
        System.out.println(v1.equals(v2));
    }

}

class Value {
    int value;

    public Value(int value) {
        this.value = value;
    }
}

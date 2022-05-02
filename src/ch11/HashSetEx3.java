package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* Set 에는 중복된 값은 들어갈 수 없다.
*   - 중복여부를 검증할 때 equals() 메서드와 hashcode() 메서드를 사용한다.
*   - 참조변수의 경우, 참조하는 인스턴스의 주소값을 비교
*   - 인스턴스의 멤버들의 값 비교를 통한 중복여부 검증을 위해서는 equals() 와 hashCode() 메서드를 오버라이드 해야한다.
* */
public class HashSetEx3 {
    public static void main(String[] args) {

        Set set = new HashSet<>();

        // String 클래스는 equals() 와 hashCode() 메서드가 이미 오버라이드 되어 있다.
        set.add(new String("abc"));
        set.add(new String("abc"));

        // Person1 클래스는 오버라이드 되어 있지 않다.
        set.add(new Person1("David", 10));
        set.add(new Person1("David", 10));

        // Person1 인스턴스 2개는 같은 멤버변수값을 같지만, 메모리 주소가 다르므로, equals(), hashCode() 에서 다른 인스턴스로 인식된다.
        Iterator it = set.iterator();
        while (it.hasNext()) {System.out.println(it.next());}
    }
}

class Person1 {
    String name;
    int age;

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}

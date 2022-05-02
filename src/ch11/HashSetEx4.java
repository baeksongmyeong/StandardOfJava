package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/*
 * Set 에는 중복된 값은 들어갈 수 없다.
 *   - 중복여부를 검증할 때 equals() 메서드와 hashcode() 메서드를 사용한다.
 *   - 참조변수의 경우, 참조하는 인스턴스의 주소값을 비교
 *   - 인스턴스의 멤버들의 값 비교를 통한 중복여부 검증을 위해서는 equals() 와 hashCode() 메서드를 오버라이드 해야한다.
 * */
public class HashSetEx4 {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add(new String("abc"));
        set.add(new String("abc"));
        // Person2 클래스의 equlas() 와 hashCode() 메서드를 오버라이드 했음
        set.add(new Person2("David", 100));
        set.add(new Person2("David", 100));

        Iterator it = set.iterator();
        while(it.hasNext()) System.out.println(it.next());
    }
}

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        // null 인지 검증
        if (null == o) {return false;}

        // 같은 클래스인지 검증
        if (this.getClass() != o.getClass()) {return false;}

        // 값을 검증
        Person2 p = (Person2) o;
        if (this.name.equals(p.name) && this.age == p.age) {return true;}

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }
}

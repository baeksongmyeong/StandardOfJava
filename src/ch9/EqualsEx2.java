package ch9;

/*
* equals() 메서드가 참조변수의 주소값이 아닌, 참조하는 인스턴스의 멤버변수값을 비교하게 하려면, equals() 메서드를 오버라이딩하면 된다.
* */


public class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(10L);
        Person p2 = new Person(10L);

        // 참조변수의 주소로 비교 ( 원래의 equals() 메서드의 기능 )
        System.out.println(p1 == p2);

        // 참조되는 인스턴스들의 멤버변수를 비교 ( 오버라이드된 equals() 메서드의 기능 )
        System.out.println(p1.equals(p2));
    }
}

class Person {

    long id;

    public Person(long id) {this.id = id;}

    @Override
    public boolean equals(Object obj) {
        if(null != obj && obj instanceof Person) {
            Person p = (Person) obj;
            return this.id == p.id ? true : false;
        }
        return false;
    }
}

package ch7;

/*
인터페이스와 클래스를 구현, 상속하는 첫번째 예제
인터페이스를 구현한 클래스는 인터페이스의 자손이 되며, 인터페이스로 참조 할 수 있다.
 */
public class FighterTest {

    public static void main(String[] args) {

        Fighter f = new Fighter();

        // 클래스처럼, 인터페이스도 인터페이스명.static변수명 을 통해 static 변수에 접근이 가능하다. 인터페이스 = 클래스 처럼 사용하는 것이다.
        System.out.println(Attackable.name);

        if( f instanceof Unit){ System.out.println("Unit 의 자손"); }
        if( f instanceof Fightable){ System.out.println("Fightable 의 자손"); }
        if( f instanceof Movable){ System.out.println("Movable 의 자손"); }
        if( f instanceof Attackable){ System.out.println("Attackable 의 자손"); }
        if( f instanceof Object){ System.out.println("Object 의 자손"); }
    }

}


class Unit {
    int currentHP; // 유닛의 체력
    int x; // 유닛 X 좌표
    int y; // 유닛 Y 좌표
}

interface Movable {
    public abstract void move(int x, int y);
}

interface Attackable {
    public static final String name = "Attackable";
    public abstract void attack(Unit u);
}

interface Fightable extends Movable, Attackable {
}

class Fighter extends Unit implements Fightable {

    // 인터페이스를 구현한다고 선언했으므로, 인터페이스 내 추상메서드들을 구현해야함
    public void move(int x, int y){}
    public void attack(Unit u){}

}

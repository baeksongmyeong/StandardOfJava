package ch9;

/*
* 얕은 복사와 깊은 복사의 차이를 확인한다.
* 얕은 복사는 클래스 A 의 인스턴스 내에 클래스 B 의 인스턴스를 참조하는 변수가 있는 경우, 새로운 클래스 B 의 인스턴스를 만들어서 참조하는 것이 아니라, 기존 인스턴스를 그대로 참조 (메모리주소 유지)
* 깊은 복사는 클래스 B 의 인스턴스를 새로 만들어서 참조 (인스턴스가 바뀌었으니, 메모리주소도 변경)
* */

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle1 c1 = new Circle1(new Point(1, 1), 2.0);
        Circle1 c2 = c1.shallowCopy();
        Circle1 c3 = c1.deepCopy();
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);

        // c1, c2 인스턴스는 동일한 Point 인스턴스를, c3 은 다른 Point 인스턴스를 참조하고 있다.
        c1.p.x = 9;
        c1.p.y = 9;

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
    }
}

class Circle1 implements Cloneable {

    Point p;  // 원점
    double r; // 반지름

    public Circle1(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    // 얕은 복사 처리
    Circle1 shallowCopy(){
        Circle1 c = null;
        try {
            c = (Circle1) super.clone();
        } catch (CloneNotSupportedException e){
            //
        }
        return c;
    }

    // 깊은 복사 처리
    Circle1 deepCopy(){
        // 먼저 나 자신(인스턴스) 를 복제한 후, 참조하는 인스턴스도 새로 만들어서 참조시킨다.
        Circle1 c = null;
        try {
            c = (Circle1) super.clone();
        } catch (CloneNotSupportedException e) {
            //
        }

        // 참조하던 인스턴스를 새로 생성한다. ( 참조하던 인스턴스의 값 복사 )
        c.p = new Point(c.p.x, c.p.y);

        return c;
    }

    @Override
    public String toString() {
        return "[p=" + p + ", r=" + r + ']';
    }
}



// Point 클래스. Circle 클래스가 참조를 하는 인스턴스가 된다.
class Point1 {
    int x;
    int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
package ch9;

/*
* Point 클래스에도 clone() 메서드를 적용하여 깊은복사가 되는지 확인해본다.
*
* */

public class ShallowDeepCopy2 {
    public static void main(String[] args) {
        Circle2 c1 = new Circle2(new Point2(10, 5), 2);
        Circle2 c2 = c1.shallowCopy();
        Circle2 c3 = c1.deepCopy();
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
        
        c1.p.x = 20;
        c1.p.y = 30;

        System.out.println("Point 값 변경 후");
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
    }
}


class Circle2 implements Cloneable {
    Point2 p; // 원점
    int r; // 반지름

    public Circle2(Point2 p, int r) {
        this.p = p;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "p=" + p +
                ", r=" + r +
                '}';
    }

    public Circle2 shallowCopy() {
        Circle2 c = null;
        try {
            c = (Circle2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Circle2 deepCopy(){
        Circle2 c = null;
        try {
            c = (Circle2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 참조하는 인스턴스를 값은 복사하여, 새로운 인스턴스 생성
        c.p = c.p.clone();

        return c;
    }
}



class Point2 implements Cloneable {
    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Point2 clone() {
        Point2 p = null;
        try {
            p = (Point2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}


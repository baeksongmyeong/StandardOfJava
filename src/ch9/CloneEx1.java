package ch9;

/*
* Object 클래스의 clone() 메서드는 인스턴스 변수만을 복제한다.
* 더 많은 기능을 넣기 위해서는 오버라이드 해야 한다.
* 오버라이드를 통해 Object 클래스의 clone() 메서드를 호출하려는 클래스는 Cloneable 인터페이스를 구현해야 한다. ( 추상 메서드는 없으니, 구현할 것은 없다 )
* */
public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point) original.clone();
        System.out.println(original);
        System.out.println(copy);
    }
}

class Point implements Cloneable {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    @Override
    public Object clone(){
        Object obj = null; // 리턴할 Object 클래스의 인스턴스
        try{
            obj = super.clone(); // Object 클래스의 clone() 메서드를 호출하게 된다. 그러면 인스턴스 변수를 복사한다.
        }catch (CloneNotSupportedException e){
            //
        }
        return obj;
    }
}
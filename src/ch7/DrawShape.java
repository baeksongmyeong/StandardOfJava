package ch7;

/*-----------------------------------------------
상속을 통한 클래스 관계
포함을 통한 클래스 관계
바탕이 되는 2개의 클래스. Shape(도형), Point(점)
-----------------------------------------------*/
class Shape {
    // 클래스 변수
    // 인스턴스 변수
    String color = "black";
    // 클래스 초기화 블럭
    static {}
    // 인스턴스 초기화 블럭
    {}
    // 생성자
    Shape(){}
    // 클래스 메서드

    // 인스턴스 메서드
    void draw(){
        System.out.printf("[color=%s]%n", color);
    }
}

class Point {
    // 클래스 변수
    // 인스턴스 변수
    int x, y;
    // 클래스 초기화 블록
    // 인스턴스 초기화 블록
    // 생성자
    Point(){ this(0, 0); }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 클래스 메서드
    // 인스턴스 메서드
    String getXY(){
        return "(" + x + ", " + y + ")";
    }
}

/*-----------------------------------------------
원은 도형이다. >> 도형 클래스를 상속한 원 클래스
원은 도형을 가지고 있다. >> X
원은 점이다. >> X
원은 점을 가지고 있다. >> 점 클래스를 포함한 원 클래스
-----------------------------------------------*/
class Circle extends Shape { // 클래스간 상속관계

    //--------------------
    // 클래스 변수
    //--------------------

    //--------------------
    // 인스턴스 변수
    //--------------------
    Point center; // 원의 중심. 클래스간 포함관계
    int r; // 반지름

    //--------------------
    // 클래스 초기화 블록
    //--------------------

    //--------------------
    // 인스턴스 초기화 블록
    //--------------------

    //--------------------
    // 생성자
    //--------------------
    Circle(){
        this(new Point(0, 0), 100);
    }

    Circle(Point center, int r){
        this.center = center; // 원의 중심
        this.r = r; // 원의 반지름
    }

    //--------------------
    // 클래스 메서드
    //--------------------

    //--------------------
    // 인스턴스 메서드
    //--------------------
    void draw(){
        System.out.printf("Circle - [center(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
    }
}

class Triangle extends Shape {

    //--------------------
    // 클래스 변수
    //--------------------

    //--------------------
    // 인스턴스 변수
    //--------------------

    // 삼각형은 점을 3개 가지고 있다.
    //Point[] p = new Point[3];
    Point[] p;

    //--------------------
    // 클래스 초기화 블록
    //--------------------

    //--------------------
    // 인스턴스 초기화 블록
    //--------------------

    //--------------------
    // 생성자
    //--------------------
    Triangle() { }

    Triangle(Point[] p) {
        this.p = p;
    }

    //--------------------
    // 클래스 메서드
    //--------------------

    //--------------------
    // 인스턴스 메서드
    //--------------------
    void draw(){
        System.out.printf("Triangle - [p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
    }
}

public class DrawShape {
    public static void main(String[] args) {
        // 삼각형 용 점들 생성
        Point[] trianglePointArr = {
                new Point(100, 100),
                new Point(140, 50),
                new Point(200, 100)
        };

        // 원 용 점 생성
        Point circlePoint = new Point(150, 150);
        
        // 삼각형 객체 생성
        Triangle triangle = new Triangle(trianglePointArr);

        // 원 객체 생성
        Circle circle = new Circle(circlePoint, 50);

        // 삼각형 draw() 메서드 호출
        triangle.draw();
        
        // 원 draw() 메서드 호출
        circle.draw();
    }
}
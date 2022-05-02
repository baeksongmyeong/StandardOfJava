package ch12;

/*
* 1. 애너테이션 새로 만들기
*
* @interface 애너테이션명 {
*   반환타입 요소이름(); // 이 것을 요소라고 한다.
*   반환타입 요소이름(); // 반환값이 있고, 매개변수는 없으며, 선언부만 존재한다.
* }
*
* 2. 애너테이션 사용
*
* 애너테이션에 정의된 모든 요소에 값을 직접 넣어줘야 한다.
* 값을 넣는 방식은 '요소명 = 값' 이다.
* 하지만, 요소가 1개이고, 요소이름이 value 이면, 컴파일러는 value = 를 자동으로 넣어준다.
* 따라서, 값만 넣어줘도 된다.
* 요소는 기본값을 지정할 수 있으며, default 예약어로 설정한다.
*
* - 어노테이션 선언
* @TestInfo {
*   int value();
* }
*
* - 클래스에 사용
* @TestInfo(
*   value = 10 또는 10 // 요소명이 value 이므로 값만 넣어줘도 컴파일러가 자동으로 value = 10 으로 바꿔준다.
* )
* public class A {}
*
* 3. 모든 애너테이션의 조상인 Annotation 은 일반 인터페이스이다. 선언부를 보면 @ 가 없다.
*   - 이 말은 Annotation 인터페이스가 Object 클래스의 자손이라는 말이고
*   - 모든 Annotation 들도 Object 클래스의 자손이라는 말이다.
*   - 따라서, Obejct 클래스가 제공하는 메서드들을 모든 Annotation 도 쓸 수 있도록 구현되어 있다.
*
* 4. 마커 애너테이션 : 요소가 없는 애너테이션들을 통칭하는 용어
*
* 5. 애너테이션 요소의 규칙
*
*   - 1. 요소가 가질수 있는 타입의 종류는 기본형, String, enum, 애너테이션, Class 뿐이다.
*   - 2. 매개변수를 선언할 수 없다.
*   - 3. 예외를 선언할 수 없다.
*   - 4. 타입에 타입 매개변수(지네릭스)를 사용할 수 없다.
*
* */

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

// 신규 어노테이션 선언
@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    // 요소 선언
    String yyyymmdd();
    String hhmmss();
}

// enum 선언
enum TestType {
    FIRST
    ,FINAL
}

// 신규 어노테이션 선언
@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    // 요소 선언
    int       count()     default 1;
    String    testBy();
    String[]  testTools() default "JUnit";
    TestType  testType()  default TestType.FIRST;
    DateTime  testDate();
}


// 클래스에 어노테이션 적용
@Deprecated(
        forRemoval = true
        ,since = "2022-04-28"
)
@SuppressWarnings("1111") // 유효하지 않은 어노테이션은 예외는 발생되지 않으나, 사용되지 않은 것으로 간주된다.
@TestInfo(
        // 어노테이션 내 모든 요소에 값 설정. default 가 있으면 지정하지 않아도 됨
        testBy = "aaa"
        ,testDate = @DateTime( yyyymmdd = "160101"
                               ,hhmmss = "235959")
)
public class AnnotationEx5 {
    public static void main(String[] args) {
        // 클래스로더가 생성한 Class 인스턴스를 참조
        Class<AnnotationEx5> cls = AnnotationEx5.class;

        // 어노테이션의 Retention 이 RUNTIME 이므로, AnnotationEx5 클래스의 Class 인스턴스에도 어노테이션의 정보가 들어가있음
        // 어노테이션에 대한 정보들도 각각 인스턴스로 되어 있을것이며, 이를 참조하도록 한다.
        TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);
        System.out.println("anno = " + anno);

        String testBy = anno.testBy();
        String[] testTools = anno.testTools();
        TestType testType = anno.testType();
        System.out.println("testBy = " + testBy);
        System.out.println("testTools = " + Arrays.toString(testTools));
        System.out.println("testType = " + testType);

        // 어노테이션 내 타입이 다른 어노테이션인 경우, 값을 가져오면 다른 어노테이션의 인스턴스가 반환된다.
        DateTime dateTime = anno.testDate();
        String yyyymmdd = dateTime.yyyymmdd();
        String hhmmss = dateTime.hhmmss();
        System.out.println("yyyymmdd = " + yyyymmdd);
        System.out.println("hhmmss = " + hhmmss);

        // 클래스에서 사용된 모든 어노테이션을 가져온다
        Annotation[] annos = cls.getAnnotations();
        for (Annotation annotation : annos) {
            System.out.println("annotation = " + annotation);
        }


    }

}

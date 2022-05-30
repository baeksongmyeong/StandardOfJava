package ch15;

/*
* 직렬화를 구현한 클래스
* */

import java.io.Serializable;

class UserInfo implements Serializable {

    // 직렬화 대상인 인스턴스 변수
    String name;
    String password;
    int age;

    public UserInfo() {
        this("Unknown", "1111", 0);
    }

    public UserInfo(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "(name='" + name + '\'' + ", password='" + password + '\'' + ", age=" + age + ')';
    }
}

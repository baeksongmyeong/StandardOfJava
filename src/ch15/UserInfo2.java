package ch15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperUserInfo {
    String name;
    String password;

    public SuperUserInfo() {
        this("Unknown", "1111");
    }

    public SuperUserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

/*
* 조상 클래스는 직렬화 미구현, 자손 클래스는 직렬화 구현
* */
public class UserInfo2 extends SuperUserInfo implements Serializable {
    int age;

    public UserInfo2() {
        this("Unknown", "1111", 0);
    }

    public UserInfo2(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    @Override
    public String toString() {
        return "(name='" + name + '\'' + ", password='" + password + '\'' + ", age=" + age + ')';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(password);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        password = in.readUTF();
        in.defaultReadObject();
    }
}

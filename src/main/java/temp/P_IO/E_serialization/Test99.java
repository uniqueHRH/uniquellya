package temp.P_IO.E_serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 직렬화 - Serialization
 * 
 * 직렬화되지 않은 조상으로부터 상속받은 인스턴스 변수에 대한 직렬화 구현
 * -> 직접 writeObject & readObject 를 추가하여, 상속받은 name 과 pw 직렬화되도록 직접 작성한다
 * -> 직렬화/역직렬화 작업시 자동 호출된다
 * -> 접근제어자가 private 인 것은 rule
 */
class SuperUserInfo {
    String  name;
    String  pw;

    SuperUserInfo() {
        this("Unknown", "1111");
    }
    SuperUserInfo(String name, String pw) {
        this.name   = name;
        this.pw     = pw;
    }
}
public class Test99 extends SuperUserInfo implements java.io.Serializable {
    int age;

    public Test99() {
        this("Unknown", "1111", 0);
    }

    public Test99(String name, String pw, int age) {
        super(name, pw);
        this.age    = age;
    }

    public String toString() {
        return "( " + name + ", " + pw + ", " + age + " )";
    }

    /**
     * name & pw 가 String 타입이기 때문에, writeUTF(), readUTF() 사용
     * 타입에 따라 writeInt(), readInt() 같은 타입도 존재
     *
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(pw);
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name    = in.readUTF();
        pw      = in.readUTF();
        in.defaultReadObject();
    }
}

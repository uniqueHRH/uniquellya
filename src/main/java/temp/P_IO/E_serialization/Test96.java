package temp.P_IO.E_serialization;

/**
 * 직렬화 - Serialization
 * -> 직렬화 : 객체에 저장된 데이터를 스트림에 쓰기(write) 위해 연속적인(serial) 데이터로 변환하는 것
 * -> 역직렬화 : 반대로 스트림으로부터 데이터를 읽어서 객체를 만드는 것
 * 
 * [ ObjectInputStream & ObjectOutputStream ]
 * -> 기반스트림을 필요로하는 보조스트림
 * -> 객체를 생성할 때, 입출력할 (직렬화/역직렬화)할 스트림 지정 필요
 * -> 객체의 직렬화/역직렬화는 객체의 모든 인스턴스변수가 첨조하고 있는 모든 객체에 대한 것이므로, 복잡하며 시간도 오래 걸린다
 * -> 직렬화할 객체가 많을 경우, ArrayList 와 같은 컬렉션에 저장한 후 직렬화하는 것이 좋다 -> 직렬화된 순서로 역직렬화 해야하는데, 순서를 고려하지 않아도 되기 때문
 * 
 * -> 인스턴스 변수의 타입이 아닌 실제 연결된 객체의 종류에 따라 결정
 * -> Object obj = new Object();	// Object 객체는 직렬화 불가능
 * -> Object obj = new String("abc");	// String 객체는 직렬화 가능
 * 
 * [ Serializable & transient ]
 * -> 직렬화가 가능한 클래스 만들기
 * -> Serializable 인터페이스 : 아무 내용도 없는 빈 인터페이스이며, 직렬화를 고려해 작성된 클래스인지 판단하는 기준이 된다
 * -> transient 제어자 : 직렬화 대상에서 제외 (타입의 기본값으로 직렬화된다)
 *
 * [ 버전관리 ]
 * -> 직렬화된 객체를 역직렬화할 때는 직렬화했을 때와 같은 클래스를 사용해야 한다
 * -> 클래스가 같더라도 클래스의 내용이 달라져 버전이 달라질 경우 문제 발생
 * -> " serialVersionUID " 가 자동 생성되며, 버전 비교가 가능함
 * -> 수동으로 버전을 관리해주는 것이 가능하다
 * -----------------------------------------------------------------
 * class Data implements java.io.Serializable {
 *      static final long serialVersionUID = 34234798532432L;
 *      int value;
 * }
 * -----------------------------------------------------------------
 */
public class Test96 implements java.io.Serializable {
    String  name;
    String  password;
    int     age;

    public Test96() {
        this("Unknown", "1111", 0);
    }

    public Test96(String name, String pw, int age) {
        this.name       = name;
        this.password   = pw;
        this.age        = age;
    }

    public String toString() {
        return "( " + name + ", " + password + ", " + age + " )";
    }
}

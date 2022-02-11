package temp.G.InnerClass;

/**
 * 내부클래스 1
 */
public class Test10 {

    class InstanceInner {}
    static class StaticInner{}

    // 인스턴스 멤거 간에는 서로 직접 접근 가능
    InstanceInner iv        = new InstanceInner();
    // static 멤버간에는 서로 직접 접근 가능
    static StaticInner cv   = new StaticInner();

    static void staticMethod() {
        // static 멤버는 인스턴스 멤버에 직접 접근 불가
//        InstanceInner obj1  = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 굳이 접근하려면 아래와 같이 객체를 생성해야 한다
        Test10 test = new Test10();
        InstanceInner obj1 = test.new InstanceInner();
    }
    void instanceMethod() {
        // 인스턴스 메서드에서는 인스턴스 멤버와 static 멤버 모두 접근 가능
        InstanceInner obj1  = new InstanceInner();
        StaticInner obj2    = new StaticInner();
        // 메소드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근 불가
//        LocalInner lv   = new LocalInner();
    }

    void myMethod() {
        class LocalInner {}
        LocalInner lv   = new LocalInner();
    }
}

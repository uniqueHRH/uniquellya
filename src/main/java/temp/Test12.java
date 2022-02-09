package temp;

import lombok.extern.slf4j.Slf4j;

/**
 * 내부클래스 3
 */
public class Test12 {

    class InstanceInner {
        int iv  = 100;
    }

    static class StaticInner {
        int iv          = 200;
        static int cv   = 300;
    }

    void myMethod() {
        class LocalInner {
            int iv      = 400;
        }
    }
}

class Test12_2 {
    public static void main(String[] args) {
        /**
         * 인스턴스 클래스의 인스턴스를 생성하려면,
         * 외부 클래서의 인스턴스를 먼저 생성해야 함
         */
        Test12 test     = new Test12();
        Test12.InstanceInner ii   = test.new InstanceInner();

        System.out.println("ii.iv === "+ii.iv);
        System.out.println("test.StaticInner.cv === "+Test12.StaticInner.cv);

        // static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다
        Test12.StaticInner si   = new Test12.StaticInner();
        System.out.println("si.iv === "+si.iv);
    }
}

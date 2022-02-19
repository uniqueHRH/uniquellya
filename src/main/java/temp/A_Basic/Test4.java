package temp.A_Basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test4 {
    int x;

    public static void main(String[] args) {
        Test4 test = new Test4();
        test.x = 10;
        System.out.println("main().x === "+test.x);

        callFirst(test.x);
        System.out.println("main().x === "+test.x);

        callSecond(test.x);
        System.out.println("main().x === "+test.x);

        callThird(test);
        System.out.println("main().x === "+test.x);
    }

    static void callFirst(int x) {
        x = 1000;
        System.out.println("callFirst.x === "+x);
    }

    static void callSecond(Integer x) {
        x = 200;
        System.out.println("callSecond.x ==="+x);
    }

    static void callThird(Test4 test) {
        test.x = 500;
        System.out.println("callthird.x ==="+test.x);
    }
}

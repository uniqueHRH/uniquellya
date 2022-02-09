package temp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test4 {
    int x;

    public static void main(String[] args) {
        Test4 test = new Test4();
        test.x = 10;
        log.debug("main().x === "+test.x);

        callFirst(test.x);
        log.debug("main().x === "+test.x);

        callSecond(test.x);
        log.debug("main().x === "+test.x);

        callThird(test);
        log.debug("main().x === "+test.x);
    }

    static void callFirst(int x) {
        x = 1000;
        log.debug("callFirst.x === "+x);
    }

    static void callSecond(Integer x) {
        x = 200;
        log.debug("callSecond.x ==="+x);
    }

    static void callThird(Test4 test) {
        test.x = 500;
        log.debug("callthird.x ==="+test.x);
    }
}

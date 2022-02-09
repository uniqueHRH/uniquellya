package temp;

import lombok.extern.slf4j.Slf4j;

/**
 * 초기화블럭
 */
@Slf4j
public class Test8 {

    static {
        log.debug("static 초기화 블럭");
    }
    {
        log.debug("non static 초기화 블럭");
    }

    public Test8() {
        log.debug("생성자");
    }

    public static void main(String[] args) {
        log.debug("test 실행");
        Test8 test = new Test8();
        log.debug("test2 실행");
        Test8 test2 = new Test8();

    }
}

package temp;

import lombok.extern.slf4j.Slf4j;

/**
 * 다형성
 */
@Slf4j
public class Test9 {

    public static void main(String[] args) {
        /**
         * one 은 Tv클래스의 멤버들만 사용할 수 있다
         * two 는 CaptionTv 의 모든 인스턴스 멤버를 사용할 수 있다
         * 
         * one / two 같은 타입의 인스턴스지만,
         * 참조변수의 타입에 따라 사용할 수 있는 멤버의 갯수가 달라진다
         */
        Tv          one = new CaptionTv();  // 참조변수 타입 : 부모타입 Tv
        CaptionTv   two = new CaptionTv();  // 참조변수 타입 : 자녀타입 CaptionTv

        one.channelDown();
        two.channelDown();
    }

}


class Tv {
    boolean power;
    int     channel;

    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}

class CaptionTv extends Tv {
    String text;

    void caption() {
        /* 생략 */
    }
}
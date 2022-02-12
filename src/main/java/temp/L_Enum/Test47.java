package temp.L_Enum;

import lombok.extern.slf4j.Slf4j;

/**
 * Enum3
 * 추상메소드 추가
 */
@Slf4j
public class Test47 {
    public static void main(String[] args) {
        log.debug("bus fare ======== " + Transportation.BUS.fare(100));
        log.debug("train fare ====== " + Transportation.TRAIN.fare(100));
        log.debug("ship fare ======= " + Transportation.SHIP.fare(100));
        log.debug("airplane fare === " + Transportation.AIRPLANE.fare(100));
    }
}

enum Transportation {
    BUS(100)        { int fare(int distance) { return distance * BASIC_FARE; }},
    TRAIN(150)      { int fare(int distance) { return distance * BASIC_FARE; }},
    SHIP(100)       { int fare(int distance) { return distance * BASIC_FARE; }},
    AIRPLANE(300)   { int fare(int distance) { return distance * BASIC_FARE; }};

    protected final int BASIC_FARE; // protected -> 각 상수에서 접근 가능

    Transportation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() { return BASIC_FARE; }
    abstract int fare(int distance);    // 거리에 따른 요금 계산
}

package temp;

import lombok.extern.slf4j.Slf4j;

/**
 * 생성자를 이용한 인스턴스의 복사
 */
@Slf4j
public class Test7 {

    public static void main(String[] args) {
        Car car     = new Car();
        Car car2    = new Car(car);

        log.debug("car.door  === "+car.door);
        log.debug("car2.door === "+car2.door);

        log.debug("car.gearType  === "+car.gearType);
        log.debug("car2.gearType === "+car2.gearType);

        log.debug("car.color  === "+car.color);
        log.debug("car2.color === "+car2.color);
    }
}


class Car {
    String  color;
    String  gearType;
    int     door;

    Car() {
        this("white", "auto", 4);
    }

    Car(Car c) {
        color       = c.color;
        gearType    = c.gearType;
        door        = c.door;
    }

    Car(String color, String gearType, int door) {
        this.color      = color;
        this.gearType   = gearType;
        this.door       = door;
    }
}
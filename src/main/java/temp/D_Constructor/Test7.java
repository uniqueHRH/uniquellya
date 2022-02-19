package temp.D_Constructor;

import lombok.extern.slf4j.Slf4j;

/**
 * 생성자를 이용한 인스턴스의 복사
 */
@Slf4j
public class Test7 {

    public static void main(String[] args) {
        Car car     = new Car();
        Car car2    = new Car(car);

        System.out.println("car.door  === "+car.door);
        System.out.println("car2.door === "+car2.door);

        System.out.println("car.gearType  === "+car.gearType);
        System.out.println("car2.gearType === "+car2.gearType);

        System.out.println("car.color  === "+car.color);
        System.out.println("car2.color === "+car2.color);
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
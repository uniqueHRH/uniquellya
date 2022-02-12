package temp.K_Generic;

import lombok.extern.slf4j.Slf4j;

/**
 * generic2 제한
 * 상속을 통한 제한이 가능하다
 */

@Slf4j
public class Test42 {
    public static void main(String[] args) {
        FruitBox<Fruits> fruitBox   = new FruitBox<Fruits>();
        FruitBox<Apples> appleBox   = new FruitBox<Apples>();
        FruitBox<Grapes> grapeBox   = new FruitBox<Grapes>();
//        FruitBox<Grape> grapeBox  = new FruitBox<Apple>();  // 타입불일치
//        FruitBox<Toy> toyBox      = new FruitBox<Toy>();    // Fruits 자손만 생성 가능

        fruitBox.add(new Fruits());
        fruitBox.add(new Apples());
        fruitBox.add(new Grapes());
        appleBox.add(new Apples());
//        appleBox.add(new Grapes());   // Grapes는 Apples 의 자손이 아님
        grapeBox.add(new Grapes());
        
        log.debug("fruitBox === " + fruitBox);
        log.debug("appleBox === " + appleBox);
        log.debug("grapeBox === " + grapeBox);
    }
}

interface Eatable {}
class FruitBox<T extends Fruits & Eatable> extends Box<T> {}
class Fruits implements Eatable { public String toString() { return "Fruits"; }}

class Apples extends Fruits { public String toString() { return "Apple";    }}
class Grapes extends Fruits { public String toString() { return "Grape";    }}
class toy                   { public String toString() { return "toy";      }}
package temp.K_Generic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * generic1
 */
class Fruit                 { public String toString() { return "Fruit"; }}
class Apple extends Fruit   { public String toString() { return "Apple"; }}
class Grape extends Fruit   { public String toString() { return "Grape"; }}
class Toy                   { public String toString() { return "Toy"; }}

@Slf4j
public class Test41 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox     = new Box<Toy>();
//        Box<Grape> grapeBox = new Box<Apple>();   // error. 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
//        appleBox.add(new Toy());  // Box<Apple> 에는 only Apple

        toyBox.add(new Toy());
//        toyBox.add(new Grape());  // Box<Toy> 에는 only Toy

        log.debug("fruitBox === " + fruitBox);
        log.debug("appleBox === " + appleBox);
        log.debug("toyBox === " + toyBox);
    }
}

class Box<T> {
    ArrayList<T> list   = new ArrayList<T>();
    void add(T item)            { list.add(item);           }
    T get(int i)                { return list.get(i);       }
    int size()                  { return list.size();       }
    public String toString()    { return list.toString();   }
}

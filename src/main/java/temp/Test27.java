package temp;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * generic3 와일드카드 ( extends )
 * 제네릭 타입이 다른 것만으로는 오버로딩이 성립하지 않는다
 *
 * <? extends T>    // T와 그 자손만 가능
 * <? super T>      // T와 그 조상만 가능
 * <?>              // All. <? extends Object> 와 동일
 */
@Slf4j
public class Test27 {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox  = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();

        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());

        log.debug("Juicer.makeJuice(fruitBox === "+Juicer.makeJuice(fruitBox));
        log.debug("Juicer.makeJuice(appleBox === "+Juicer.makeJuice(appleBox));
    }
}

class Fruit2                { public String toString() { return "Fruit"; }}
class Apple2 extends Fruit2 { public String toString() { return "Apple2"; }}
class Grape2 extends Fruit2 { public String toString() { return "Grape2"; }}
class Juice {
    String name;

    Juice(String name)          { this.name = name + "Juice";   }
    public String toString()    { return name;                  }
}
class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
        String tmp = "";

        for(Fruit2 f : box.getList()) tmp += f + " ";
        return new Juice(tmp);
    }
}

class FruitBox2<T extends Fruit2> extends Box2<T> {}
class Box2<T> {
    ArrayList<T> list   = new ArrayList<T>();
    void add(T item)            { list.add(item);       }
    T get(int i)                { return list.get(i);   }
    ArrayList<T> getList()      { return list;          }
    int size()                  { return list.size();   }
    public String toString() { return list.toString();  }
}

package temp.N_Lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Lambda
 * Method References
 * [ 메소드 참조 ]
 * - 메소드를 간결하게 지칭할 수 있는 방법으로, 람다가 사용되는 곳 어디서든 사용 가능
 * - 호출(실행)하는 것이 아니라 참조만 하기 때문에, 괄호() 는 쓰지 않는다
 *
 * [ 종류 ]                         [ 람다 ]                         [ 메소드 참조 ]
 * static 메소드 참조                (x) -> className.method(x)      ClassName::method
 * 인스턴스 메소드 참조               (obj, x) -> obj.method(x)        ClassName::method
 * 특정 객체 인스턴스 메소드 참조       (x) -> obj.method(x)             obj::method
 *
 * 하나의 메소드만 호출하는 람다식은
 * '클래스명::메소드명' or '참조변수::메소드명' 으로 바꿀 수 있다
 * 메소드 참조는 람다식을 static 변수처럼 다룰 수 있도록 해주며,
 * 코드를 간략히 하는데 유용해서 많이 사용
 */
public class Test52 {
    public static void main(String[] args) {
        Function<String, Integer> f   = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2  = Integer::parseInt;          // method 참조

        BiFunction<String, String, Boolean> b   = (s1, s2) -> s1.equals(s2);
        BiFunction<String, String, Boolean> b2  = String::equals;   // method 참조

        MyClass obj = new MyClass();
        Function<String, Boolean> mf  = (x) -> obj.equals(x); // 람다식
        Function<String, Boolean> mf2 = obj::equals; // 메소드 참조

//      [ 생성자의 메소드 호출 ]
        Supplier<MyClass>   s   = () -> new MyClass();  // 람다식
        Supplier<MyClass>   s2  = MyClass::new;         // 메소드 참조

        Function<Integer, MyClass> fm   = (i) -> new MyClass(i);    // 람다식
        Function<Integer, MyClass> fm2  = MyClass::new;             // 람다식

        BiFunction<Integer, String, MyClass> bf  = (i, t) -> new MyClass(i,t);
        BiFunction<Integer, String, MyClass> bf2 = MyClass::new;

//      [ 배열 생성 ]
        Function<Integer, int[]> fa  = x -> new int[x]; // 람다식
        Function<Integer, int[]> fa2 = int[]::new;      // 메소드 참조
    }
}

class MyClass {
    public MyClass() {}
    public MyClass(Integer i) {}
    public MyClass(Integer i, String t) {}
}
package temp.N_Lambda;

/**
 * Lambda
 * Basic
 */
@FunctionalInterface
interface MyFunction {
    void run(); // public abstract void run();
}

public class Test50 {
    static void execute(MyFunction f) { // 매개변수의 타입이 MyFunction 인 메소드
        f.run();
    }
    
    static MyFunction getMyFunction() { // 반환타입이 MyFunction 인 메소드
        MyFunction function = () -> System.out.println("f3.run()");
        return function;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction 의 run() 구현
        MyFunction f1   = () -> System.out.println("f1.run()");
        MyFunction f2   = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };
        MyFunction f3   = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}

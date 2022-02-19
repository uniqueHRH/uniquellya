package temp.C_VariableArguments;

/**
 * 가변인자
 */
public class Test6 {

    public static void main(String[] args) {

        call("hi", "hello", "nice to meet you");
        callToInteger(1,2,3,4,5,6,7);
    }
    static void call(String... str) {
        System.out.println("call ======" + str.toString());
    }
    static void callToInteger(int... integer) {
        System.out.println("callToInteger ===== " + integer);
    }
}
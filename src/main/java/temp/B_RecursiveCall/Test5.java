package temp.B_RecursiveCall;

/**
 * 재귀호출
 */
public class Test5 {

    public static void main(String[] args) {

        int result = refact(5);
        System.out.println("result === "+result);
    }

//    static int  refact(int x) {
//        int result = 0;
//
//        if(x == 1) {
//            result = 1;
//        } else {
//            result = x * refact(x-1);
//        }
//        return result;
//    }

    static int refact(int x) {
        if(x == 1) return 1;
        return x * refact(x-1);
    }
}

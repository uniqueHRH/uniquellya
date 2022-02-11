package temp.A_Basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test3 {

    public static void main(String[] args) {
        MyMath mm = new MyMath();

        long result1    = mm.add(5L, 3L);
        long result2    = mm.subtract(5L, 3L);
        long result3    = mm.multiply(5L, 3L);
        double result4  = mm.divide(5L, 3L);

        log.debug("result1 ==="+result1);
        log.debug("result2 ==="+result2);
        log.debug("result3 ==="+result3);
        log.debug("result4 ==="+result4);
    }

    static class MyMath {
        long add(long a, long b) {
            return a+b;
        }
        long subtract(long a, long b) {
            return a - b;
        }
        long multiply(long a, long b) {
            return a * b;
        }
        double divide(double a, double b) {
            return a / b;
        }
    }
}

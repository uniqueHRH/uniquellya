package temp.N_Lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambda
 * Predicate
 */
@Slf4j
public class Test51 {
    public static void main(String[] args) {
        Function<String, Integer>   f   = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String>   g   = (i) -> Integer.toBinaryString(i);

        Function<String, String>    h   = f.andThen(g);
        Function<Integer, Integer>  h2  = f.compose(g);

        log.debug("h.apply('FE') === " + h.apply("FE"));
        log.debug("h2.apply(2) === " + h2.apply(2));

        Function<String, String>    f2  = x -> x;   // 항등함수 (identity function)
        log.debug("f2.apply('AAA') === " + f2.apply("AAA"));    // AAA가 그대로 출력됨

        Predicate<Integer>  p       = i -> i < 100;
        Predicate<Integer>  q       = i -> i < 200;
        Predicate<Integer>  r       = i -> i % 2 == 0;
        Predicate<Integer>  notP    = p.negate();   // i >= 100

        Predicate<Integer> all      = notP.and(q.or(r));
        log.debug("all.test(150) === " + all.test(150));    // true

        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String>   p2      = Predicate.isEqual(str1);
        boolean             result  = p2.test(str2);
        log.debug("result === " + result);
    }
}

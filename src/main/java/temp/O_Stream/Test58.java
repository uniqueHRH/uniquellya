package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Stream
 * 중간연산 - [ Optional<T> & OptionInt/OptionLong/OptionDouble ]
 *
 * null 이 올 수 있는 값을 감싸는 Wrapper Class
 * NellPointerException 방지
 * .orElse()    : Optional 안의 값이 null 이든 아니든 항상 호출
 * .orElseGet() : Optional 안의 값이 null 일 경우에만 호출
 */
@Slf4j
public class Test58 {
    public static void main(String[] args) {
        Optional<String>    optStr  = Optional.of("abcde");
        Optional<Integer>   optInt  = optStr.map(String::length);

        log.debug("optStr === " + optStr.get());
        log.debug("optInt === " + optInt.get());
        log.debug("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();
        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        log.debug("result1 === " + result1);
        log.debug("result2 === " + result2);
        log.debug("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        OptionalInt optInt1 = OptionalInt.of(0);    // 0 저장
        OptionalInt optInt2 = OptionalInt.empty();  // 빈 객체 생성

        log.debug("optInt1.isPresent() ==== " + optInt1.isPresent());   // true
        log.debug("optInt2.isPresent() ==== " + optInt2.isPresent());   // false
        log.debug("optInt1.getAsInt() === " + optInt1.getAsInt());      // 0
//      log.debug("optInt2.getAsInt() === " + optInt2.getAsInt());      // NoSuchElementException
        log.debug("optInt1 === " + optInt1);
        log.debug("optInt2 === " + optInt2);
        log.debug("optInt1.equals(optInt2)? === " + optInt1.equals(optInt2));
        log.debug("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Optional<String> opt    = Optional.ofNullable(null);    // null 저장
        Optional<String> opt2   = Optional.empty();             // 빈 객체 생성

        log.debug("opt === " + opt);
        log.debug("opt2 === " + opt2);
        log.debug("opt.equals(opt2) ? " + opt.equals(opt2));    // true
        log.debug("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);

        log.debug("result3 === " + result3);
        log.debug("result4 === " + result4);
    }

    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch(Exception e) {
            return defaultValue;
        }
    }
}

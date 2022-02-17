package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream
 * 최종연산 - [ reduce & allMatch/anyMatch/noneMatch & fineFirst/findAny]
 *
 * allMatch/anyMatch/noneMatch  : 전체 일치하는지/일부 일치하는지/전혀 일치하지 않는지 Boolean
 * fineFirst/findAny            : 조건에 이맃하는 첫번째 값 반환 / 병렬 스트림의 경우 Any 사용
 * reduce                       : Stream 의 요소를 줄여가며 연산을 수행하고 최종결과 반환
 *                                초기값 identitu 를 갖는 reduce() 도 존재 -> 초기값과 Stream 의 첫번째 요소로 연산 시작
 */
@Slf4j
public class Test59 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream"
                , "OptionalDouble", "IntStream", "count", "sum"
        };
        Stream.of(strArr).forEach(System.out::println);

        boolean             noEmptyStr  = Stream.of(strArr).noneMatch(s -> s.length() == 00);
        Optional<String>    sWord       = Stream.of(strArr)
                                            .filter(s -> s.charAt(0) == 's').findFirst();

        log.debug("noEmptyStr === " + noEmptyStr);
        log.debug("sWord === " + sWord.get());
        log.debug("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        /**
         * mapToInt
         * String 을 문자열 length 기준으로 int 로 변환
         */
        // Stream<String[]> 을 IntStream 으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count   = intStream1.reduce(0, (a, b) -> a + 1);
        int sum     = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        log.debug("count === " + count);
        log.debug("sum === " + sum);
        log.debug("max === " + max);
        log.debug("min === " + min);
    }
}

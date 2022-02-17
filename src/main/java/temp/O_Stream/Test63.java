package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Stream
 * [ Collector Interface 구현 ]
 *
 * reduce() 와 collect() 의 차이
 * 근본적으로 하는 일은 서로 동일하며, collect가 그룹화와 분할, 집계 등에 유영하며 병렬화에 유리하다
 */
@Slf4j
public class Test63 {
    public static void main(String[] args) {
        String[]        strArr      = {"aaa", "bbb", "ccc"};
        Stream<String>  strStream   = Stream.of(strArr);

        String          result      = strStream.collect(new ConcatCollector());

        log.debug("Arrays.toString(strArr) === " + Arrays.toString(strArr));
        log.debug("result === " + result);
    }
}

class ConcatCollector implements Collector<String, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return () -> new StringBuilder();
//      return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb, s) -> sb.append(s);
//      return StringBuilder::append;
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb, sb2) -> sb.append(sb2);
//      return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return sb -> sb.toString();
//      return StringBuilder::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
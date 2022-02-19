package temp.O_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream
 * Basic
 * - 데이터 소스를 변경하지 않는다
 * 일회용이다 -> Iterator 로 컬렉션 요소를 모두 읽고나면 다시 사용할 수 없는 것처럼, 스트림도 동일하기 때문에 필요시 다시 생성해야 한다
 * 작업을 내부 반복으로 철리한다 -> forEach() 메소드 안에 for 문이 포함되어 있다
 * 다양한 연산
 *
 * stream1 과 stream2 의 dataSource 는 다르지만, 읽고 정렬 및 출력하는 방법은 동일하다
 */
public class Test53 {
    public static void main(String[] args) {
        String[]        strArr  = {"aaa", "ddd", "ccc" };
        List<String>    strList = Arrays.asList(strArr);

        Stream<String> strStream1   = strList.stream();
        Stream<String> strStream2   = Arrays.stream(strArr);

        strStream1.sorted().forEach(System.out::println);
        strStream2.sorted().forEach(System.out::println);
    }
}

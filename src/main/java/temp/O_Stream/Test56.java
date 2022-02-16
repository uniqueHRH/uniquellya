package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Stream
 * [ IntSummaryStatistics ]
 * sum, average 와 같은 연산을 함께 수행하기 위해서는 Stream 객체를 여러개 만들어야 한다
 * 이럴 때 사용할 수 있는 메소드 -> 동시 사용 가능
 */
@Slf4j
public class Test56 {
    public static void main(String[] args) {
        Student2[] stuArr   = {
                new Student2("김정민", 3, 300),
                new Student2("이수빈", 3, 150),
                new Student2("장민지", 1, 100),
                new Student2("심석민", 2, 250),
                new Student2("박민식", 2, 200),
                new Student2("임지은", 1, 100)
        };
        Stream<Student2> stuStream  = Stream.of(stuArr);
//        stuStream.sorted(Comparator.comparing(Student2::getBan)
//                .thenComparing(Comparator.naturalOrder()))
//                .forEach(System.out::println);

        stuStream   = Stream.of(stuArr);    // 스트림 재생성
        IntStream stuScoreStream    = stuStream.mapToInt(Student2::getTotalScore);

        IntSummaryStatistics stat   = stuScoreStream.summaryStatistics();

        log.debug("count ===== " + stat.getCount());
        log.debug("sum ======= " + stat.getSum());
        System.out.printf("average === %.2f%n", stat.getAverage());
        log.debug("min ======= " + stat.getMin());
        log.debug("max ======= " + stat.getMax());
    }
}

class Student2 implements Comparable<Student> {
    String  name;
    int     ban;
    int     totalScore;
    Student2(String name, int ban, int totalScore) {
        this.name       = name;
        this.ban        = ban;
        this.totalScore = totalScore;
    }
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }
    String getName()    { return name;      }
    int getBan()        { return ban;       }
    int getTotalScore() { return totalScore;}

    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
    }
}
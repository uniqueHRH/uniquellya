package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Stream
 * 최종연산사 - [ collect() ]
 *
 * partitioningBy       : 조건에 따른 Stream 요소 분리
 * collectingAndThen    : collecting 후, 그 값으로 새로운 메소드를 호출하여 활용
 */
@Slf4j
public class Test61 {
    public static void main(String[] args) {
        Student4[] stuArr  = {
                new Student4("나자바", true, 1, 1, 300),
                new Student4("김지미", false, 1, 1, 250),
                new Student4("김자바", true, 1, 1, 200),
                new Student4("이지미", false, 1, 2, 150),
                new Student4("남자바", true, 1, 2, 100),
                new Student4("안지미", false, 1, 2, 50),
                new Student4("황지미", false, 1, 3, 100),
                new Student4("강지미", false, 1, 3, 150),
                new Student4("이자바", true, 1, 3, 200),

                new Student4("나자바", true, 2, 1, 300),
                new Student4("김지미", false, 2, 1, 250),
                new Student4("김자바", true, 2, 1, 200),
                new Student4("이지미", false, 2, 2, 150),
                new Student4("남자바", true, 2, 2, 100),
                new Student4("안지미", false, 2, 2, 50),
                new Student4("황지미", false, 2, 3, 100),
                new Student4("강지미", false, 2, 3, 150),
                new Student4("이자바", true, 2, 3, 200)
        };
        System.out.printf("1. 단순분할 (성별 분할) %n");

        Map<Boolean, List<Student4>> stuBySex    = Stream.of(stuArr)
                                                    .collect(partitioningBy(Student4::isMale));

        List<Student4> maleStudent      = stuBySex.get(true);
        List<Student4> femaleStudent    = stuBySex.get(false);

        for(Student4 s : maleStudent)   log.debug("s === " + s);
        for(Student4 s : femaleStudent) log.debug("s === " + s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long>  stuNumBySex = Stream.of(stuArr)
                                            .collect(partitioningBy(Student4::isMale, counting()));
        
        log.debug("남학생수 === " + stuNumBySex.get(true));
        log.debug("여학생수 === " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student4>> topScoreBySex   = Stream.of(stuArr)
                                                            .collect(partitioningBy(Student4::isMale,
                                                                    maxBy(comparingInt(Student4::getScore))));
        log.debug("남학생 1등 === " + topScoreBySex.get(true));
        log.debug("여학생 1등 === " + topScoreBySex.get(false));
        log.debug("----------------------------------------------------------");

        Map<Boolean, Student4> topScoreBySex2   = Stream.of(stuArr)
                                                    .collect(partitioningBy(Student4::isMale,
                                                            collectingAndThen(
                                                                    maxBy(comparingInt(Student4::getScore)), Optional::get)
                                                            ));
        log.debug("남학생 1등 === " + topScoreBySex2.get(true));
        log.debug("여학생 1등 === " + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean, Map<Boolean, List<Student4>>> failedStuBySex = Stream.of(stuArr)
                                                                    .collect(partitioningBy(Student4::isMale
                                                                            , partitioningBy(s -> s.getScore() <= 100)));
        List<Student4> failedMaleStu    = failedStuBySex.get(true).get(true);
        List<Student4> failedFemaleStu  = failedStuBySex.get(false).get(true);

        for(Student4 s : failedMaleStu)     log.debug("s === " + s);
        for(Student4 s : failedFemaleStu)   log.debug("s === " + s);
    }
}

class Student4 {
    String  name;
    boolean isMale;
    int     hak;    // 학년
    int     ban;    // 반
    int     score;

    Student4(String name, boolean isMale, int hak, int ban, int score) {
        this.name   = name;
        this.isMale = isMale;
        this.hak    = hak;
        this.ban    = ban;
        this.score  = score;
    }
    String  getName()   { return name;  }
    boolean isMale()    { return isMale;}
    int     getHak()    { return hak;   }
    int     getBan()    { return ban;   }
    int     getScore()  { return score; }
    
    public String toString() {
        return String.format("[ %s, %s, %d학년, %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }
}
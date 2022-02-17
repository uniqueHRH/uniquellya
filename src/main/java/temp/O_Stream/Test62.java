package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
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
public class Test62 {
    public static void main(String[] args) {
        Student5[] stuArr  = {
                new Student5("나자바", true, 1, 1, 300),
                new Student5("김지미", false, 1, 1, 250),
                new Student5("김자바", true, 1, 1, 200),
                new Student5("이지미", false, 1, 2, 150),
                new Student5("남자바", true, 1, 2, 100),
                new Student5("안지미", false, 1, 2, 50),
                new Student5("황지미", false, 1, 3, 100),
                new Student5("강지미", false, 1, 3, 150),
                new Student5("이자바", true, 1, 3, 200),

                new Student5("나자바", true, 2, 1, 300),
                new Student5("김지미", false, 2, 1, 250),
                new Student5("김자바", true, 2, 1, 200),
                new Student5("이지미", false, 2, 2, 150),
                new Student5("남자바", true, 2, 2, 100),
                new Student5("안지미", false, 2, 2, 50),
                new Student5("황지미", false, 2, 3, 100),
                new Student5("강지미", false, 2, 3, 150),
                new Student5("이자바", true, 2, 3, 200)
        };
        System.out.printf("1. 단순그룹화 (반별 그룹화) %n");
        Map<Integer, List<Student5>> stuByBan   = Stream.of(stuArr)
                                                    .collect(groupingBy(Student5::getBan));
        for(List<Student5> ban : stuByBan.values()) {
            for(Student5 s : ban) {
                log.debug("s === " + s);
            }
        }
        
        System.out.printf("%n2. 단순그룹화(성절별 그룹화)%n");
        Map<Student5.Level, List<Student5>> stuByLevel  = Stream.of(stuArr)
                                                            .collect(groupingBy(s -> {
                                                                if(s.getScore() >= 200) return Student5.Level.HIGH;
                                                                if(s.getScore() >= 100) return Student5.Level.MID;
                                                                else                    return Student5.Level.LOW;
                                                            }));
        TreeSet<Student5.Level> keySet  = new TreeSet<>(stuByLevel.keySet());
        for(Student5.Level key : keySet) {
            log.debug("[ " + key + " ]");
            for(Student5 s : stuByLevel.get(key)) log.debug("s === " + s);
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student5.Level, Long> stuCntByLevel = Stream.of(stuArr)
                                                    .collect(groupingBy(s -> {
                                                        if(s.getScore() >= 200) return Student5.Level.HIGH;
                                                        if(s.getScore() >= 100) return Student5.Level.MID;
                                                        else                    return Student5.Level.LOW;
                                                    }, counting()));
        for(Student5.Level key : stuCntByLevel.keySet()) System.out.printf("[%s] = %d명, ", key, stuCntByLevel.get(key));
        /*
        for(List<Student5> level : stuByLevel.values()) {
            log.debug("");
            for(Student5 s : level) {
                log.debug("s === " + s);
            }
        }
         */

        System.out.printf("%n%n4. 다중그룹화(학년별, 반별)%n");
        Map<Integer, Map<Integer, List<Student5>>> stuByHakNBan = Stream.of(stuArr)
                                                                    .collect(groupingBy(Student5::getHak
                                                                            , groupingBy(Student5::getBan)));
        for(Map<Integer, List<Student5>> hak : stuByHakNBan.values()) { // 반별 grouping
            for(List<Student5> ban : hak.values()) {    // 인원 List
                log.debug("");
                for (Student5 s : ban) log.debug("s === " + s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student5>> topStuByHakNBan    = Stream.of(stuArr)
                                                                    .collect(groupingBy(Student5::getHak,
                                                                            groupingBy(Student5::getBan,
                                                                                    collectingAndThen(
                                                                                            maxBy(comparingInt(Student5::getScore))
                                                                                    , Optional::get
                                                                                    )
                                                                            )
                                                                    ));
        for(Map<Integer, Student5> ban  : topStuByHakNBan.values())
            for(Student5 s : ban.values())
                log.debug("s === " + s);

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student5.Level>> stuByScoreGroup    = Stream.of(stuArr)
                                                                .collect(groupingBy(s -> s.getHak() + " - " + s.getBan(),
                                                                        mapping(s -> {
                                                                            if(s.getScore() >= 200) return Student5.Level.HIGH;
                                                                            if(s.getScore() >= 100) return Student5.Level.MID;
                                                                            else                    return Student5.Level.LOW;
                                                                        }, toSet())
                                                                ));
        Set<String> keySet2 = stuByScoreGroup.keySet();
        for(String key : keySet2) {
            log.debug("[ " + key + " ]" + stuByScoreGroup.get(key));
        }
    }
}

class Student5 {
    String  name;
    boolean isMale;
    int     hak;    // 학년
    int     ban;    // 반
    int     score;

    Student5(String name, boolean isMale, int hak, int ban, int score) {
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
    // groupingBy() 에서 사용 / 성적 구분
    enum Level { HIGH, MID, LOW }
}
package temp.O_Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Stream
 * 최종연산사 - [ collect() ]
 *
 * 컬렉션&배열로 변환   : toList(), toSet(), toMap(), toCollection(), toArray()
 * 통계               : counting(), summingInt(), averageingInt(), maxBy(), minBy()
 * 리듀싱             : reducing()
 * 문자열 결합         : joinging()
 */
public class Test60 {
    public static void main(String[] args) {
        Student3[] stuArr    = {
                new Student3("김수빈", 3, 100),
                new Student3("이지민", 2, 300),
                new Student3("박정수", 1, 200),
                new Student3("최지윤", 1, 250),
                new Student3("장은비", 2, 50),
                new Student3("심수민", 2, 200),
                new Student3("소지은", 3, 250),
        };
        // 학생 이름만 List<String> 에 저장
        List<String> names  = Stream.of(stuArr).map(Student3::getName)
                                            .collect(Collectors.toList());
        System.out.println("name === " + names);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        // Stream to Array
        Student3[] stuArr2   = Stream.of(stuArr).toArray(Student3[]::new);
        for(Student3 s : stuArr2) System.out.println("stuArr2 === " + s);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        // Stream 을 Map<String, Student> 로 변환 . key = 학생이름
        Map<String, Student3> stuMap    = Stream.of(stuArr)
                                            .collect(Collectors.toMap(s -> s.getName(), p -> p));
        for(String name : stuMap.keySet())
            System.out.println(name + " - " + stuMap.get(name));
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        long count      = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                                .collect(summingInt(Student3::getTotalScore));
        System.out.println("count === " + count);
        System.out.println("totalScore === " + totalScore);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        totalScore  = Stream.of(stuArr)
                        .collect(reducing(0, Student3::getTotalScore, Integer::sum));
        System.out.println("totalScore === " + totalScore);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Optional<Student3> topStudent   = Stream.of(stuArr)
                                            .collect(maxBy(Comparator.comparingInt(Student3::getTotalScore)));
        System.out.println("topStudent === " + topStudent.get());
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        IntSummaryStatistics stat   = Stream.of(stuArr)
                                        .collect(summarizingInt(Student3::getTotalScore));
        System.out.println("stat === " + stat);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        String stuNames = Stream.of(stuArr).map(Student3::getName)
                        .collect(joining(", ", "{", "}"));
        System.out.println(stuNames);
    }
}

class Student3 implements Comparable<Student3> {
    String  name;
    int     ban;
    int     totalScore;

    Student3(String name, int ban, int totalScore) {
        this.name       = name;
        this.ban        = ban;
        this.totalScore = totalScore;
    }
    String getName()    { return name;      }
    int getBan()        { return ban;       }
    int getTotalScore() { return totalScore;}

    @Override
    public int compareTo(Student3 o) {
        return o.totalScore - this.totalScore;
    }
}

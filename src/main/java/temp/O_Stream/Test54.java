package temp.O_Stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Stream
 * 정렬 - Basic
 */
@Slf4j
public class Test54 {
    public static void main(String[] args) {
        Stream<Student> studentStream   = Stream.of(
                new Student("이수란", 3, 300),
                new Student("김가지", 3, 100),
                new Student("이김밥", 2, 200),
                new Student("장오이", 1, 250),
                new Student("최수박", 1, 250),
                new Student("이감자", 2, 100),
                new Student("진라면", 3, 150)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)) // 반별 정렬
//                .thenComparing(Comparator.naturalOrder())           // 기본정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String  name;
    int     ban;
    int     totalScore;
    Student(String name, int ban, int totalScore) {
        this.name       = name;
        this.ban        = ban;
        this.totalScore = totalScore;
    }
    public String toString() {
        return String.format("[ %s, %d, %d ]", name, ban, totalScore);
    }
    String getName()    { return name;          }
    int getBan()        { return ban;           }
    int getToTalScore() { return totalScore;    }

    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
    }
}
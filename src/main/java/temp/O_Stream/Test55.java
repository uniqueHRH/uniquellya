package temp.O_Stream;

import java.io.File;
import java.util.stream.Stream;

/**
 * Stream
 * 중간연산
 * map()    : 원하는 필드만 뽑아내거나 특정 형태로 변환
 * peek()   : 연산과 연 사이에 바르게 처리되었는지 체크
 */
public class Test55 {
    public static void main(String[] args) {
        // File 객체를 가지고 있는 Stream<File> 생성
        File[] fileArr  = {
            new File("Ex1.java"),
            new File("Ex1.bak"),
            new File("Ex2.java"),
            new File("Ex1"),
            new File("Ex1.txt")
        };
        Stream<File> fileStream         = Stream.of(fileArr);

        // map() 으로 Stream<File>을 Stream<String> 으로 변환
        Stream<String> filenameStream   = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);        // 모든 파일 이름 출력

        fileStream  = Stream.of(fileArr);                   // File 객체를 가진 Stream<File> 재생성

        /**
         * peek() 을 추가하여 연산할 경우, 이전까지 결과만 다음 스텝으로 넘겨준다
         * 결과값 : TXT
         * peek() 을 사용하지 않을 경우, 전체 결과를 다음 스텝으로 넘겨다
         * 결과값 : JAVABAKTXT
         */
        fileStream.map(File::getName)                       // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf('.') != -1)          // 확장자가 없는 것은 제외
//                .peek(s -> System.out.printf("filename === %s%n", s))
                .map(s -> s.substring(s.indexOf('.') +1))   // 확장자만 추출
//                .peek(s -> System.out.printf("extension === %s%n", s))
                .map(String::toUpperCase)                   // 대문자 변환
                .distinct()                                 // 중복 제거
                .forEach(System.out::print);                // JAVABAKTXT
    }
}

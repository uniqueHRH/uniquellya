package temp.M_Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation
 */
@Deprecated                 // 더이상 사용하지 않는 메소드나 필드에 사용
@SuppressWarnings("1111")   // 유효하지 않은 어노테이션은 무시
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101", hhmmss="235959"))
public class Test49 {
    public static void main(String[] args) {
        /**
         * Test33.class : 클래스 객체를 의미하는 리터럴
         * 모든 클래스 파일은 Classloader에 의해 메모리에 올라갈 때,
         * 클래스에 대한 정보가 담긴 객체 생성 => 클래스 객체
         * 이 객체를 참조할 때 'class명.class' 로 사용
         */
//      Test33의 Class 객체 획득
        Class<Test49> cls   = Test49.class;

        TestInfo anno   = (TestInfo)cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() === " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() === " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() === " + anno.testDate().hhmmss());

        for(String str : anno.testTools()) System.out.println("testTools === " + str);

//      Test33에 적용된 모든 어노테이션을 획득
        Annotation[] annoArr    = cls.getAnnotations();
        for(Annotation a : annoArr) System.out.println("anno === " + a);
    }
}

@Retention(RetentionPolicy.RUNTIME) // 실행시에 사용 가능하도록 지정
@interface TestInfo {
    int         count()     default 1;
    String      testedBy();
    String[]    testTools() default "JUnit";
    TestType    testType()  default TestType.FIRST;
    DateTime    testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface  DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType { FIRST, FINAL }
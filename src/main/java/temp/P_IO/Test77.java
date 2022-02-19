package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * I/O
 * [ 문자 기반 Stream ]
 * -> 문자 데이터를 사용하는 것 외에는 바이트기반 Stream 과 사용은 거의 동일하다
 * 
 * Reader & Writer
 * -> 문자 기반 Stream 의 조상 역할
 * -> byte 대신 char 배열 사용
 * -> 여러 종류의 인코딩과 자바에서 사용하는 유니코드(UTF-16)간의 변환 자동 처리
 * -> Reader    = 특정 인코딩을 읽어서 유니코드로 변환
 *    Writer    = 유니코드를 특정 인코딩으로 변환 후 저장
 *
 * [ FileReader & FileWriter ]
 * pipedReader  & pipedWriter
 * StringReade  & StringWriter
 */
@Slf4j
public class Test77 {
    public static void main(String[] args) {
        try {
            String          fileName    = "Test77.txt";
            FileInputStream fis         = new FileInputStream(fileName);
            FileReader      fr          = new FileReader(fileName);

            int data    = 0;
            // FileInputStream 을 이용해 파일 내용을 읽어 화면에 출력
            System.out.println("=============== FileInputStream ===============");
            while((data = fis.read()) != -1) System.out.print((char)data);
            System.out.println();
            fis.close();

            // FileReader 를 이용해 파일 내용을 읽어 화면에 출력
            System.out.println("=============== FileReader ===============");
            while((data = fr.read()) != -1) System.out.print((char)data);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

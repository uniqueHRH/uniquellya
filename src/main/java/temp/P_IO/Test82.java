package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * I/O
 * [ 문자 기반 보조 Stream ]
 *
 * bufferedReader       & bufferedWriter
 * [ inputStreamReader  & &outputStreamWriter ]
 * -> 바이트 기반 Stream 을 문자 기반 Stream 으로 연결시켜주는 역할
 * -> 바이트기반 스트림을 지정된 인코딩의 문자데이터로 변환
 */
@Slf4j
public class Test82 {
    public static void main(String[] args) {
        String line = "";

        try {
            InputStreamReader   isr = new InputStreamReader(System.in);
            BufferedReader      br  = new BufferedReader(isr);

            log.debug("사용중인 OS 의 인코딩 === " + isr.getEncoding());

            do {
                System.out.print("문장을 입력하세요 . 마치려면 q를 입력하세요 >");
                line = br.readLine();
                System.out.println("입력사신 문장 === " + line);
            } while(!line.equalsIgnoreCase("q"));
//            br.close(); // System.in 과 같은 표준입출력은 닫지 않아도 닫힌다
            System.out.println("프로그램을 종료합니다");
        } catch (IOException e) {}
    }
}

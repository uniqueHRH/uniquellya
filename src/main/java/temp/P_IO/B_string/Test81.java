package temp.P_IO.B_string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * I/O
 * [ 문자 기반 보조 Stream ]
 *
 * [ bufferedReader     & bufferedWriter ]
 * -> buffer 를 이용해 효율을 높인다
 * -> bufferedReader    -> readLine() : 데이터를 라인단위로 read
 * -> bufferedWriter    -> newLine()  : 줄바꿈
 * inputStreamReader    & &outputStreamWriter
 */
public class Test81 {
    public static void main(String[] args) {
        try {
            FileReader      fr  = new FileReader("Test81.java");
            BufferedReader  br  = new BufferedReader(fr);

            String      line    = "";

            for(int i=1; (line = br.readLine()) != null; i++) {
                // ";" 를 포함한 라인 출력
                if(line.indexOf(";") != -1) System.out.println(i + " === " + line);
            }
            br.close();
        } catch (IOException e) {}
    }
}

package temp.P_IO.B_string;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * I/O
 * [ 문자 기반 Stream ]
 *
 * [ FileReader & FileWriter ]
 * pipedReader  & pipedWriter
 * StringReade  & StringWriter
 */
public class Test78 {
    /**
     * 파일의 공백을 모두 없앤다
     * @param args
     */
    public static void main(String[] args) {
        try {
            FileReader fr   = new FileReader(args[0]);
            FileWriter fw   = new FileWriter(args[0]);

            int        data = 0;

            while((data = fr.read()) != -1) {
                if(data != '\t' && data != '\n' && data != ' ' && data != '\r') fw.write(data);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

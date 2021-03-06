package temp.P_IO.B_string;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * I/O
 * [ 문자 기반 Stream ]
 *
 * FileReader       & FileWriter
 * pipedReader      & pipedWriter
 * [ StringReader   & StringWriter ]
 * -> 입출 대상이 메모리
 * -> StringWriter 에 출력되는 데이터는 내부 StringBuffer 에 저장
 */
public class Test80 {
    public static void main(String[] args) {
        String          inputData   = "ABCD";
        StringReader    input       = new StringReader(inputData);
        StringWriter    output      = new StringWriter();

        int             data        = 0;

        try {
            while((data = input.read()) != -1) {
                output.write(data);             // void write(int b)
            }
        } catch (IOException e) {}

        System.out.println("input data ==== " + inputData);
        System.out.println("output data === " + output.toString());
        System.out.println("output data === " + output.getBuffer().toString());

    }
}

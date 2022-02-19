package temp.P_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Stream
 * [ 표준입출력 ]
 *
 * setOut() & setErr() & setIn()    : 입출 대상 변경
 */
public class Test84 {
    public static void main(String[] args) {
        System.out.println("out : Hello World!");
        System.err.println("err : Hello World!");


        PrintStream         ps  = null;
        FileOutputStream    fos = null;
        
        try {
            fos = new FileOutputStream("Test84.txt");
            ps  = new PrintStream(fos);
            System.setOut(ps);          // System.out 의 출력대상을 Test84.txt 로 변경
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");
    }
}

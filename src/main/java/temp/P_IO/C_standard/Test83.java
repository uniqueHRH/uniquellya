package temp.P_IO.C_standard;

import java.io.IOException;

/**
 * Stream
 * [ 표준입출력 ]
 *
 * System.in & System.out & System.err
 */
public class Test83 {
    public static void main(String[] args) {
        try {
            int input = 0;

            while((input=System.in.read()) != -1) {
                System.out.println("input === " + input + ", (char)input === " + (char)input);
            }
        } catch (IOException e) {}
    }
}

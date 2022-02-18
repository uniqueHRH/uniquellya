package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * I/O
 * [ FileInputStream & FileOutputStream ]
 */
@Slf4j
public class Test67 {
    public static void main(String args[]) throws IOException {
        log.debug("arg === " + Arrays.toString(args));

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1]);

            int data = 0;
            while ((data = fis.read()) != -1) {  // 읽어들여올 값이 존재할 때
                fos.write(data);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
}

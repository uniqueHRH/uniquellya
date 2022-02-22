package temp.P_IO.E_serialization;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * 직렬화 - Serialization
 *
 * 직렬화된 UserInfo.ser 파일 역직렬화
 */
public class Test98 {
    public static void main(String[] args) {
        try {
            String              fileName    = "UserInfo.ser";
            FileInputStream     fis         = new FileInputStream(fileName);
            BufferedInputStream bis         = new BufferedInputStream(fis);

            ObjectInputStream   in          = new ObjectInputStream(bis);

            // 객체를 읽을 때는 출력한 순서와 일치해야 한다
            Test96 t1  = (Test96)in.readObject();
            Test96 t2  = (Test96)in.readObject();
            ArrayList   list    = (ArrayList)in.readObject();

            System.out.println(t1);
            System.out.println(t2);
            System.out.println(list);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

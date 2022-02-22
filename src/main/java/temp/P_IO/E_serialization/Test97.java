package temp.P_IO.E_serialization;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 직렬화 - Serialization
 * 
 * 생성한 객체를 직렬화하여 UserInfo.ser 에 저장
 */
public class Test97 {
    public static void main(String[] args) {
        try {
            String                  fileName    = "UserInfo.ser";
            FileOutputStream        fos         = new FileOutputStream(fileName);
            BufferedOutputStream    bos         = new BufferedOutputStream(fos);

            ObjectOutputStream      out         = new ObjectOutputStream(bos);  // 직렬화

            Test96    t1  = new Test96("JavaMan", "1234", 30);
            Test96    t2  = new Test96("JavaWoman", "4321", 26);

            ArrayList<Test96>       list        = new ArrayList<>();
            list.add(t1);
            list.add(t2);
            // 객체를 직렬화한다
            out.writeObject(t1);
            out.writeObject(t2);
            out.writeObject(list);

            out.close();

            System.out.println("직렬화가 잘 끝났습니다");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

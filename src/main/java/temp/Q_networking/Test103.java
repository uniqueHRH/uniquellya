package temp.Q_networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * networking
 * [ URL3 ]
 *
 * URL 에 연결하여 내용을 읽어온다
 * -> 문자열이기 때문에 BufferedReader 사용
 * -> openStream()
 *    -> 호출하여 URLConnection 을 얻은 다음 다시 getInputStream() 호출한 것과 같다
 *    ----------------------------------------------------------------------
 *    InputStream in        = url.openStream();
 *    vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
 *    URLConnection conn    = openConnection();
 *    InputStream in        = conn.getInputStream();
 */
public class Test103 {
    public static void main(String[] args) {
        URL             url     = null;
        BufferedReader  input   = null;

        String address  = "https://www.naver.com";
        String line     = "";

        try {
            url     = new URL(address);
            input   = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

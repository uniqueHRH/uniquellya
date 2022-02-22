package temp.Q_networking;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * networking
 * [ URL4 ]
 *
 */
public class Test104 {
    public static void main(String[] args) {
        URL                 url     = null;
        InputStream         in      = null;
        FileOutputStream    out     = null;
        String              address = "https://drive.google.com/drive/my-drive";

        int ch  = 0;

        try {
            url = new URL(address);
            in  = url.openStream();
            out = new FileOutputStream("Test104.zip");

            while((ch = in.read()) != -1) {
                out.write(ch);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

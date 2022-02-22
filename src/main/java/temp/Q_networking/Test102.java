package temp.Q_networking;

import java.net.URL;
import java.net.URLConnection;

/**
 * networking
 * [ URL2 ]
 *
 * -> 포로토콜://호스트명:포트번호/경로명/파일명?퀄리스트링#참조
 * 프로토콜         : 자원에 접근하기 위해 서버와 통신하는데 사용되는 통신규약 (http)
 * 호스트명         : 자원을 제공하는 서버의 이름 (www.naver.com)
 * 포트번호         : 통신에 사용되는 서버의 포트번호 (80)
 * 경로명           : 접근하려는 자원이 저장된 서버상의 위치(/sample/)
 * 파일명           : 접근하려는 자원의 이름 (hello.html)
 * 쿼리(query)     : URL에서 '?' 이후 부분 (referer=unique)
 * 참조(anchor)    : URL에서 '#' 이후 부분 (index1)
 */
public class Test102 {
    public static void main(String[] args) {
        URL     url     = null;
        String  address = "http://www.unique.com/sample/unique.html";

        try {
            url = new URL(address);
            URLConnection conn  = url.openConnection();

            System.out.println("conn.toString() ========================= " + conn);
            System.out.println("getAllowUserInteraction() =============== " + conn.getAllowUserInteraction());
            System.out.println("conn.getConnectTimeout() ================ " + conn.getConnectTimeout());
            System.out.println("conn.getContent() ======================= " + conn.getContent());
            System.out.println("conn.getContentEncoding() =============== " + conn.getContentEncoding());
            System.out.println("conn.getContentLength() ================= " + conn.getContentLength());
            System.out.println("conn.getContentType() =================== " + conn.getContentType());
            System.out.println("conn.getDate() ========================== " + conn.getDate());
            System.out.println("conn.getDefaultAllowUserInteraction() === " + conn.getDefaultAllowUserInteraction());
            System.out.println("conn.getDefaultUseCaches() ============== " + conn.getDefaultUseCaches());
            System.out.println("conn.getDoInput() ======================= " + conn.getDoInput());
            System.out.println("conn.getDoOutput() ====================== " + conn.getDoOutput());
            System.out.println("conn.getExpiration() ==================== " + conn.getExpiration());
            System.out.println("conn.getHeaderFields() ================== " + conn.getHeaderFields());
            System.out.println("conn.getIfModifiedSince() =============== " + conn.getIfModifiedSince());
            System.out.println("conn.getLastModified() ================== " + conn.getLastModified());
            System.out.println("conn.getReadTimeout() =================== " + conn.getReadTimeout());
            System.out.println("conn.getURL() =========================== " + conn.getURL());
            System.out.println("conn.getUseCaches() ===================== " + conn.getUseCaches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

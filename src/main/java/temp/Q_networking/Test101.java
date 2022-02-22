package temp.Q_networking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * networking
 * [ URL ]
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
public class Test101 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URL("http://www.uniquellya.com:80/sample/hello.html?referer=uniquellya#index");   // URL 객체 생성
        
        System.out.println("url.getAuthority() ===== " + url.getAuthority());
        System.out.println("url.getDefaultPort() === " + url.getDefaultPort());
        System.out.println("url.getPort() ========== " + url.getPort());
        System.out.println("url.getFile() ========== " + url.getFile());
        System.out.println("url.getHost() =========== " + url.getHost());
        System.out.println("url.getPath() ========== " + url.getPath());
        System.out.println("url.getProtocol() ====== " + url.getProtocol());
        System.out.println("url.getQuery() ========= " + url.getQuery());
        System.out.println("url.getRef() =========== " + url.getRef());
        System.out.println("url.getUserInfo() ====== " + url.getUserInfo());
        System.out.println("url.toExternalForm() === " + url.toExternalForm());
        System.out.println("url.toURI() ============ " + url.toURI());
    }
}

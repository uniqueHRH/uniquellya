package temp.Q_networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * networking
 * [ IP ]
 */
public class Test100 {
    public static void main(String[] args) {
        InetAddress     ip      = null;
        InetAddress[]   ipArr   = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() ====== " + ip.getHostName());     // www.naver.com
            System.out.println("getHostAddress() === " + ip.getHostAddress());  // naver ip주소
            System.out.println("toString() ========= " + ip.toString());        // www.naver.com/naver ip주소

            byte[] ipAddr   = ip.getAddress();
            System.out.println("getAddress() === " + Arrays.toString(ipAddr));

            String result   = "";
            for(int i=0; i<ipAddr.length; i++) {
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress() + 256 === " + result);
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ip= InetAddress.getLocalHost();
            System.out.println("getHostName() ====== " + ip.getHostName());     // PC 이름
            System.out.println("getHostAddress() === " + ip.getHostAddress());  // PC ip
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr   = InetAddress.getAllByName("www.naver.com");    // 하나의 도메인명(www.naver.com) 에 여러 IP 주소 매핑 가능 -> getAllByName() 으로 호출

            for(int i=0; i<ipArr.length; i++) {
                System.out.println("iparr[" + i + "] === " + ipArr[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

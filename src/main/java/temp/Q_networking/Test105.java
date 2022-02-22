package temp.Q_networking;

/**
 * networking
 * [ Socket ]
 *
 * TCP 프로토콜 & UDP 프로토콜
 * [ TCP 프로토콜 ]
 * -> 연결방식      : 연결기반 (connection-oriented)
 *                    -> 연결 후 통신 (전화, 파일 전송)
 *                    -> 1:1 통신
 * -> 특징         : 데이터의 경계를 구분하지 않음 (byte - stream)
 *                  신뢰성 있는 데이터 전송
 *                    -> 데이터의 전송 순서 보장
 *                    -> 데이터 수신여부 확인 (데이터 손실시 재전송됨)
 *                    -> 패킷을 관리할 필요 없음
 *                  UDP보다 전송 속도 느림
 * -> 관련 클래스    : Socket
 *                   ServerSocket
 * [ UDP 프로토콜 ]
 * -> 연결방식      : 비연결기반 (connectionless-oriented)
 *                    -> 연결없이 통신 (소포, 동영상/게임 데이터 전송)
 *                    -> 1:1, n:n, 1:n 통신
 * -> 특징         : 데이터의 경계 구분 (datagram)
 *                  신뢰성 없는 데이터 전송
 *                    -> 데이터의 전송 순서가 바뀔 수 있음
 *                    -> 데이터 수신여부 미확인 (데이터 손실시 알 수 없음)
 *                    -> 패킷을 관리해야 함
 *                  UCP보다 전송 속도 빠름
 * -> 관련 클래스    : DatagramSocket
 *                   DatagramPacket
 *                   MulticastSocket
 */
public class Test105 {
    public static void main(String[] args) {

    }
}

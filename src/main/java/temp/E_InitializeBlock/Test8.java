package temp.E_InitializeBlock;

/**
 * 초기화블럭
 */
public class Test8 {

    static {
        System.out.println("static 초기화 블럭");
    }
    {
        System.out.println("non static 초기화 블럭");
    }

    public Test8() {
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("test 실행");
        Test8 test = new Test8();
        System.out.println("test2 실행");
        Test8 test2 = new Test8();

    }
}

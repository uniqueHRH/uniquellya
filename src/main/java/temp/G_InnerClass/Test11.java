package temp.G_InnerClass;

/**
 * 내부클래스 2
 */
public class Test11 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv     = outerIv;  // 외부 클래스의 private 멤버도 접근 가능
        int getIiv  = outerCv;
    }

    static class StaticInner {
        // static 클래스는 외부 클래스의 인스턴스 멤버에 접근 불가
//        int siv         = outerIv;
        static int scv  = outerCv;
    }

    void myMethod() {
        int lv          = 0;
        final int LV    = 0;

        class LocalInner {
            int liv     = outerIv;
            int liv2    = outerCv;
            int liv3    = lv;
            int liv4    = LV;
        }
    }
}

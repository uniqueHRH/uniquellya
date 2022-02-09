package temp;

public class Test2 {

    int temp1 = 100;
    static int temp2 = 200;

    public int add(int one, int two) {
        int temp1 = 200;
        int temp2 = 300;
        int result = one + two + temp1;

        return result;
    }

    public int dis(int one, int two) {
        return one - two;
    }

    public int trib(int one, int two) {
        return one * two;
    }

    public int disc(int one, int two) {
        return one / two;
    }
}

package temp;

public class Test {

    public static void main(String[] args) {
        Test2 temp = new Test2();

        System.out.println("add ==="+temp.add(1, 2));
        System.out.println("add ==="+temp.dis(5, 2));
        System.out.println("add ==="+temp.trib(2, 2));
        System.out.println("add ==="+temp.disc(4, 2));

        System.out.println("String temp === "+temp.temp1);
        System.out.println("String temp === "+temp.temp2);

        String temp1 = "edit temp";
        String temp2 = "edit temp2";

        System.out.println("temp1 === "+temp1);
        System.out.println("temp2 === "+temp2);
    }

}

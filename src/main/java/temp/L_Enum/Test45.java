package temp.L_Enum;

/**
 * Enum1
 */

enum Direction { EAST, SOUTH, WEST, NORTH }

public class Test45 {
    public static void main(String[] args) {
        Direction d1    = Direction.EAST;
        Direction d2    = Direction.valueOf("WEST");
        Direction d3    = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 === " + d1);
        System.out.println("d2 === " + d2);
        System.out.println("d3 === " + d3);

        System.out.println("d1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//        System.out.println("d2 > d3 ? " + (d1 > d3));  // 에러 -> enum 은 <, > 로 비교 불가
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));
//        ※ compareTo : 양쪽이 동일하면 0 / 좌측이 크면 + / 우측이 크면 -

        switch (d1) {
            case EAST:  // Direction.EAST 로 사용 불가
                System.out.println("The direction is EAST");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH");
                break;
            case WEST:
                System.out.println("The direction is WEST");
                break;
            case NORTH:
                System.out.println("The direction is NORTH");
                break;
        }

        /**
         * d.name()     상수의 이름을 String으로 반환
         * d.ordinal()  상수가 정의된 순서를 반환 (0부터 시작)
         */
//        for(Direction d : Direction.values();
        Direction[] dArr    = Direction.values();
        for(Direction d : dArr) System.out.printf("%s = %d%n", d.name(), d.ordinal());
    }
}

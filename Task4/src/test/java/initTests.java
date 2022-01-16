import org.junit.Test;

public class initTests {

    @Test
    public void Test1() {
        for (int timer = 0; timer < 10; timer++) {
            int[][] block = Main.initBlock(3);
            for (var i : block) {
                for (var r : i) {
                    System.out.print("  " + r);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    @Test
    public void Test2() {
        for (int timer = 0; timer < 10; timer++) {
            int[][] block = Main.initBlock(4);
            for (var i : block) {
                for (var r : i) {
                    System.out.print("  " + r);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

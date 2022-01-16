import org.junit.Test;

public class CoefficientsTests {

    @Test
    public void Test4x4() {
        int[][] blocks = new int[][]{{1, 2, 0, 3}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 4}};
        Board initial = new Board(blocks);
        Priority priority = new Priority(1, 1, 4);
        Solver solver = new Solver(initial, priority);

        printResult(solver, 1, 1);
        printResult(solver, 10, 1);
        printResult(solver, 1, 10);
        printResult(solver, 10, 10);

    }

    @Test
    public void Test3x3() {
        int[][] blocks = new int[][]{{1, 2, 3},{0 ,8, 7}, {6, 5, 4}};
        Board initial = new Board(blocks);
        Priority priority = new Priority(1, 1, 3);
        Solver solver = new Solver(initial, priority);

        printResult(solver, 1, 1);
        printResult(solver, 10, 1);
        printResult(solver, 1, 10);
        printResult(solver, 10, 10);

    }


    public void printResult(Solver solver, int a, int b){
        if (solver.solve()) {
            System.out.println("a = " + a + ", b = " + b);
            System.out.println("Minimum number of moves = " + solver.moves());
        } else {
            System.out.println("Cannot solve");
        }
    }
}

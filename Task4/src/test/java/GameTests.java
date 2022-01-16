import org.junit.Test;

public class GameTests {

    @Test
    public void Test4x4() {
        int[][] blocks = new int[][]{{1, 2, 0, 3}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 4}};
        Board initial = new Board(blocks);
        Priority priority = new Priority(1, 1, 4);
        Solver solver = new Solver(initial, priority);
        if (solver.solve()) {
            System.out.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.getResult()) {
                board.print();
            }
        } else {
            System.out.println("Cannot solve");
        }
    }

    @Test
    public void Test3x3() {
        int size = 3;
        int[][] blocks = new int[][]{{1, 2, 3},{0 ,8, 7}, {6, 5, 4}};
        Board initial = new Board(blocks);
        Priority priority = new Priority(1, 1, size);
        Solver solver = new Solver(initial, priority);
        if (solver.solve()) {
            System.out.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.getResult()) {
                board.print();
            }
        } else {
            System.out.println("Cannot solve");
        }
    }

    @Test
    public void Test4x4NotSolution() {
        int[][] blocks = new int[][]{{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};
        Board initial = new Board(blocks);
        Priority priority = new Priority(1, 1, 4);
        Solver solver = new Solver(initial, priority);
        if (solver.solve()) {
            System.out.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.getResult()) {
                board.print();
            }
        } else {
            System.out.println("Cannot solve");
        }
    }
}

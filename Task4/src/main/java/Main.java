public class Main {

    public static void main (String args []) {

        int N = 4;
        int a = 1;
        int b = 1;

        int[][] blocks = initBlock(N);
        Board initial = new Board(blocks);
        Priority priority = new Priority(a, b, N);
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

    public static int[][] initBlock(int size){
        int[][] block = new int[size][size];
        boolean[] checkNewNumbers = new boolean[size * size];
        int sizeX2 = size * size;
        for (int i = 0; i < sizeX2; i++) checkNewNumbers[i] = false;

        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col++)
            {
                while (true) {
                    int random_number = (int) (Math.random() * sizeX2);
                    if (!checkNewNumbers[random_number]){
                        block[row][col] = random_number;
                        checkNewNumbers[random_number] = true;
                        break;
                    }
                }

            }
        return block;
    }

}


public class Priority {

    private final int a;
    private final int b;
    private final int blockSize;

    public Priority(int a, int b, int blockSize) {
        this.blockSize = blockSize;
        this.a = a;
        this.b = b;
    }

    public int manhattan(int[][] block, int length) {
        int res = 0;
        for (int row = 0; row < blockSize; row++) {
            for (int col = 0; col < blockSize; col++) {
                int value = block[row][col];
                if (value == 0)
                    continue;
                int diffRows = Math.abs(targetRowFor(value) - row);
                int diffCols = Math.abs(targetColumnFor(value) - col);
                res += diffRows + diffCols;
            }
        }
        return a * res + b * length;
    }

    private int targetRowFor(int value) {
        if (value == 0)
            return blockSize - 1;
        return (value - 1) / blockSize;
    }

    private int targetColumnFor(int value) {
        if (value % blockSize == 0)
            return blockSize - 1;
        return (value % blockSize) - 1;
    }
}
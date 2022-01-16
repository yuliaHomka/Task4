import java.util.HashSet;
import java.util.Set;

public class Board {
    private final int[][] blocks;
    private final int blockSize;
    private int zeroX;
    private int zeroY;
    private int notRightPosition;

    public int[][] getBlocks() {
        return blocks;
    }

    public Board(int[][] blocks) {
        this.blocks = blocks;
        this.blockSize = blocks.length;
        this.notRightPosition = 0;

        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                if ((blocks[i][j] != i * blockSize + j + 1) && blocks[i][j] != 0) {
                    this.notRightPosition += 1;
                }
                if (blocks[i][j] == 0) {
                    this.zeroX =  i;
                    this.zeroY = j;
                }
            }
        }
    }


    public boolean isGoal() {
        return this.notRightPosition == 0;
    }

    public Iterable<Board> neighbors() {
        Set<Board> boardList = new HashSet<>();
        boardList.add(swap(getNewBlock(), zeroX, zeroY, zeroX, zeroY + 1));
        boardList.add(swap(getNewBlock(), zeroX, zeroY, zeroX, zeroY - 1));
        boardList.add(swap(getNewBlock(), zeroX, zeroY, zeroX - 1, zeroY));
        boardList.add(swap(getNewBlock(), zeroX, zeroY, zeroX + 1, zeroY));
        return boardList;
    }

    private int[][] getNewBlock() {

        int[][] clone = new int[this.blockSize][];
        for (int i = 0; i < this.blockSize; i++)
            clone[i] = this.blocks[i].clone();

        return clone;
    }

    private Board swap(int[][] origin, int x1, int y1, int x2, int y2) {

        if (x2 > -1 && x2 < blocks.length && y2 > -1 && y2 < blocks.length) {
            int t = origin[x2][y2];
            origin[x2][y2] = origin[x1][y1];
            origin[x1][y1] = t;
            return new Board(origin);
        } else
            return null;
    }

    public boolean isSolvable(){
        int sum = zeroX + 1;

        for (int row = 0; row < blockSize - 1; row++){
            for (int col = 0; col < blockSize - 1; col++ ){
                if (blocks[row][col] > blocks[row][col + 1]) sum += 1;
            }
            if (blocks[row][blockSize - 1] > blocks[row + 1][0]) sum += 1;
        }

        for (int col = 0; col < blockSize - 1; col++ ){
            if (blocks[blockSize - 1][col] > blocks[blockSize - 1][col + 1]) sum += 1;
        }

        if (blocks[blockSize - 1][blockSize - 1] > blocks[0][0]) sum += 1;

        return sum % 2 == 0;
    }

    public void print() {
        for(int i = 0; i < blockSize; i++){
            for (int t = 0; t < blockSize; t++)
                System.out.print(blocks[i][t] + "  ");
            System.out.println();
        }
        System.out.println();
    }
}
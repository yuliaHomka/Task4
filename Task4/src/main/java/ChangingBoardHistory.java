public class ChangingBoardHistory implements Comparable<ChangingBoardHistory>{

    private final ChangingBoardHistory history;
    private final Board currentBoard;
    private final int length;
    private final int priority;

    public ChangingBoardHistory(ChangingBoardHistory history, Board board, int length, Priority p) {
            this.history = history;
            this.currentBoard = board;
            this.length = length;
            this.priority = p.manhattan(currentBoard.getBlocks(), length);

        }

    public ChangingBoardHistory getHistory() {
        return history;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public int getLength() {
        return length;
    }

    @Override
        public int compareTo(ChangingBoardHistory changingBoardHistory) {
            return (this.priority - changingBoardHistory.priority);
        }
}



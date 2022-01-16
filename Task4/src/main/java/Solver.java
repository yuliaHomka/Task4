import java.util.*;

public class Solver {

    private final Board initial;
    private final List<Board> result = new ArrayList<>();
    private final Priority priority;

    public List<Board> getResult() {
        return result;
    }

    public Solver(Board initial, Priority p) {
        this.initial = initial;
        this.priority = p;
    }

    public boolean solve() {
        if(!initial.isSolvable()) return false;

        PriorityQueue<ChangingBoardHistory> priorityQueue = new PriorityQueue<ChangingBoardHistory>();
        priorityQueue.add(new ChangingBoardHistory(null, initial, 1, priority));

        while (!priorityQueue.isEmpty()) {
            ChangingBoardHistory headBranchOfHistory = priorityQueue.poll();

            if(headBranchOfHistory.getCurrentBoard().isGoal()) {
                addToResult(new ChangingBoardHistory(headBranchOfHistory,
                                                     headBranchOfHistory.getCurrentBoard(),
                                               headBranchOfHistory.getLength() + 1, priority));
                return true;
            }

            for (Board board : headBranchOfHistory.getCurrentBoard().neighbors()) {
                if (board != null && !containsInPath(headBranchOfHistory, board))
                    priorityQueue.add(new ChangingBoardHistory(headBranchOfHistory, board, headBranchOfHistory.getLength() + 1, priority));
            }

        }
        return true;
    }

    private void addToResult(ChangingBoardHistory changingBoardHistory){
        changingBoardHistory = changingBoardHistory.getHistory();
        while (changingBoardHistory != null) {
            result.add(changingBoardHistory.getCurrentBoard());
            changingBoardHistory = changingBoardHistory.getHistory();
        }
        Collections.reverse(result);
    }

    private boolean containsInPath(ChangingBoardHistory changingBoardHistory, Board board){
        while (changingBoardHistory.getHistory()!= null){
            if(changingBoardHistory.getCurrentBoard().equals(board)) return true;
            changingBoardHistory = changingBoardHistory.getHistory();
        }
        return false;
    }






    public int moves() {
        return result.size() - 1;
    }
}

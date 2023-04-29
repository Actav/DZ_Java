public class chess {
    public static void main(String[] args) {
        QueensProblem problem = new QueensProblem();
        problem.solve();
    }
}

class QueensProblem {

    private static final int BOARD_SIZE = 8;
    private final int[][] board;

    public QueensProblem() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public void solve() {
        if (placeQueens(0)) {
            printQueens();
        } else {
            System.out.println("No solution found.");
        }
    }

    private boolean placeQueens(int row) {
        if (row == BOARD_SIZE) {
            return true;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (isSafe(row, i)) {
                board[row][i] = 1;
                if (placeQueens(row + 1)) {
                    return true;
                }
                board[row][i] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
            int rowDiff = row - i;
            if (col - rowDiff >= 0 && board[i][col - rowDiff] == 1) {
                return false;
            }
            if (col + rowDiff < BOARD_SIZE && board[i][col + rowDiff] == 1) {
                return false;
            }
        }
        return true;
    }

    private void printQueens() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}


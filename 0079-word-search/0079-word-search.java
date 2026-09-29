class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try every cell as the starting point
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean backtrack(char[][] board, String word,
                      int row, int col, int index) {

        // Word completely matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Move in 4 directions
        boolean found =
                backtrack(board, word, row - 1, col, index + 1) || // Up
                backtrack(board, word, row + 1, col, index + 1) || // Down
                backtrack(board, word, row, col - 1, index + 1) || // Left
                backtrack(board, word, row, col + 1, index + 1);   // Right

        // Backtracking: restore original character
        board[row][col] = temp;

        return found;
    }
}
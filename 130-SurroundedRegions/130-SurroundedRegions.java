// Last updated: 7/9/2026, 3:03:06 PM
class Solution {
    private int m, n;
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O')
            return;

        board[r][c] = '#';

        for (int[] d : dirs)
            dfs(board, r + d[0], c + d[1]);
    }
}
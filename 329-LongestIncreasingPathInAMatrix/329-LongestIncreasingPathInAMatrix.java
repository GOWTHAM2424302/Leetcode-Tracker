// Last updated: 7/9/2026, 3:02:00 PM
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, dp, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] mat, int[][] dp, int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];

        int best = 1;

        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length &&
                    mat[x][y] > mat[i][j]) {
                best = Math.max(best, 1 + dfs(mat, dp, x, y));
            }
        }

        return dp[i][j] = best;
    }
}
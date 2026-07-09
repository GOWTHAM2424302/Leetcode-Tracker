// Last updated: 7/9/2026, 3:01:55 PM
class Solution {
    int m, n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j);
            dfs(heights, atl, m - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j])
                    ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }

    private void dfs(int[][] h, boolean[][] vis, int i, int j) {

        vis[i][j] = true;

        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && y >= 0 && x < m && y < n &&
                    !vis[x][y] &&
                    h[x][y] >= h[i][j]) {
                dfs(h, vis, x, y);
            }
        }
    }
}
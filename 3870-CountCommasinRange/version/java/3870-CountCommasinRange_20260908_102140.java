// Last updated: 9/8/2026, 10:21:40 AM
1class Solution {
2    private int m, n;
3    private boolean[][] visited;
4    private char[][] grid;
5
6    public boolean containsCycle(char[][] grid) {
7        this.grid = grid;
8        m = grid.length;
9        n = grid[0].length;
10        visited = new boolean[m][n];
11
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                if (!visited[i][j]) {
15                    if (dfs(i, j, -1, -1)) {
16                        return true;
17                    }
18                }
19            }
20        }
21
22        return false;
23    }
24
25    private boolean dfs(int row, int col, int parentRow, int parentCol) {
26        visited[row][col] = true;
27
28        int[] dr = {-1, 1, 0, 0};
29        int[] dc = {0, 0, -1, 1};
30
31        for (int i = 0; i < 4; i++) {
32            int newRow = row + dr[i];
33            int newCol = col + dc[i];
34
35            if (newRow < 0 || newRow >= m ||
36                newCol < 0 || newCol >= n) {
37                continue;
38            }
39
40            if (grid[newRow][newCol] != grid[row][col]) {
41                continue;
42            }
43
44            // Ignore the cell from which we came
45            if (newRow == parentRow && newCol == parentCol) {
46                continue;
47            }
48
49            // Already visited and not parent = cycle
50            if (visited[newRow][newCol]) {
51                return true;
52            }
53
54            if (dfs(newRow, newCol, row, col)) {
55                return true;
56            }
57        }
58
59        return false;
60    }
61}